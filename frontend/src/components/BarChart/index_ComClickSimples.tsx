import React, { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import axios from "axios";
import { useHistory } from "react-router-dom";
import { LogProcesso } from "types/LogProcesso";
import { round } from "utils/format";
import { BASE_URL } from "utils/requests";

//versao com click simples navega para pagina semanal da estrutura desejada.

// Adiciona uma exportação vazia para garantir que o arquivo seja tratado como um módulo
export {};

type SeriesData = {
  name: string;
  data: number[];
};

type ChartData = {
  labels: {
    categories: string[];
  };
  series: SeriesData[];
};

const BarChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: {
      categories: [],
    },
    series: [
      {
        name: "% Corretos",
        data: [],
      },
      {
        name: "% Incorretos",
        data: [],
      },
      {
        name: "Sem Movimento",
        data: [],
      },
    ],
  });

  const [dataWithIds, setDataWithIds] = useState<{ id_ESTRUTURA?: number }[]>(
    []
  );
  const history = useHistory();

  useEffect(() => {
    axios
      .get(`${BASE_URL}/LogDashBoardProcessamentos2/SUM7DIAS`)
      .then((response) => {
        const data = response.data as LogProcesso[];

        const myLabels = data.map((x) => x.nm_ESTRUTURA.trimEnd());
        const correctSeries = data.map((x) =>
          Number(x.totalregistros) > 0
            ? round(
                (100.0 * Number(x.regcorretos)) / Number(x.totalregistros),
                2
              )
            : 0
        );
        const incorrectSeries = correctSeries.map((value) =>
          value === 0 ? 0 : round(100 - value, 2)
        );
        const noMovementSeries = data.map((x) =>
          Number(x.totalregistros) === 0 ? 100 : 0
        );

        const filteredData = data
          .map((item, index) => ({
            label: myLabels[index],
            correct: correctSeries[index],
            incorrect: incorrectSeries[index],
            noMovement: noMovementSeries[index],
            id_ESTRUTURA: item.id_ESTRUTURA,
          }))
          .filter((item) => !(item.correct > 95 && item.incorrect < 10));

        setDataWithIds(filteredData);

        setChartData({
          labels: {
            categories: filteredData.map((item) => item.label),
          },
          series: [
            {
              name: "% Corretos",
              data: filteredData.map((item) => item.correct),
            },
            {
              name: "% Incorretos",
              data: filteredData.map((item) => item.incorrect),
            },
            {
              name: "Sem Movimento",
              data: filteredData.map((item) => item.noMovement),
            },
          ],
        });
      });
  }, []);

  const handleDataPointClick = (event: any, chartContext: any, config: any) => {
    const { seriesIndex, dataPointIndex } = config;

    // Obtemos o id_ESTRUTURA da série de dados clicada
    const id_ESTRUTURA = dataWithIds[dataPointIndex]?.id_ESTRUTURA;
    const label = chartData.labels.categories[dataPointIndex];

    if (id_ESTRUTURA !== undefined) {
      history.push(`/pagina12?id=${id_ESTRUTURA}&data=${label}`);
    }
  };

  const options = {
    chart: {
      stacked: true,
      events: {
        dataPointSelection: handleDataPointClick,
      },
    },
    plotOptions: {
      bar: {
        horizontal: true,
        barHeight: "80%",
      },
    },
    colors: ["#1616e0", "#da2424", "#9c989c"], // Definido como array fixo de cores
    dataLabels: {
      enabled: true,
      style: {
        fontSize: "10px",
      },
      formatter: (val: number, opts: any) => {
        const seriesName = opts.w.globals.seriesNames[opts.seriesIndex];
        if (seriesName === "Sem Movimento" && val === 100) {
          return "0.0%";
        }
        return `${val.toFixed(2)}%`;
      },
    },
    xaxis: {
      categories: chartData.labels.categories,
      max: 100,
      labels: {
        style: {
          fontSize: "10px",
        },
      },
    },
    yaxis: {
      labels: {
        style: {
          fontSize: "10px",
        },
        offsetX: -10,
      },
    },
    tooltip: {
      y: {
        formatter: (val: number, opts: any) => {
          const seriesName = opts.w.globals.seriesNames[opts.seriesIndex];
          if (seriesName === "Sem Movimento" && val === 100) {
            return "0.0%";
          }
          return `${val.toFixed(2)}%`;
        },
      },
    },
    legend: {
      position: "top" as const,
      fontSize: "10px",
    },
    fill: {
      type: "solid",
    },
  };

  return (
    <Chart
      options={options}
      series={chartData.series}
      type="bar"
      height="800"
      width="750"
    />
  );
};

export default BarChart;
