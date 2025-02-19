import axios from "axios";
import React, { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { LogProcesso } from "types/LogProcesso";
import { round } from "utils/format";
import { BASE_URL } from "utils/requests";

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
    ],
  });

  useEffect(() => {
    axios
      .get(`${BASE_URL}/LogDashBoardProcessamentos2/SUM7DIAS`)
      .then((response) => {
        const data = response.data as LogProcesso[];

        const myLabels = data.map((x) => x.nm_ESTRUTURA);
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

        // Ordenar os dados com base nos valores incorretos em ordem decrescente
        const sortedData = data
          .map((item, index) => ({
            label: myLabels[index],
            correct: correctSeries[index],
            incorrect: incorrectSeries[index],
          }))
          .sort((a, b) => b.incorrect - a.incorrect);

        setChartData({
          labels: {
            categories: sortedData.map((item) => item.label),
          },
          series: [
            {
              name: "% Corretos",
              data: sortedData.map((item) => item.correct),
            },
            {
              name: "% Incorretos",
              data: sortedData.map((item) => item.incorrect),
            },
          ],
        });
      });
  }, []);

  const options = {
    chart: {
      stacked: true,
    },
    plotOptions: {
      bar: {
        horizontal: true,
        barHeight: "70%",
      },
    },
    colors: ["#1616e0", "#da2424"], // Azul e vermelho principais
    dataLabels: {
      enabled: true,
      style: {
        fontSize: "8px", // Tamanho da fonte
      },
      formatter: (val: number) => (val === 0 ? "" : `${val.toFixed(2)}%`), // Exibir vazio quando 0%
    },
    xaxis: {
      categories: chartData.labels.categories,
      max: 100,
      labels: {
        style: {
          fontSize: "8px", // Tamanho da fonte dos labels
        },
      },
    },
    yaxis: {
      labels: {
        align: "left" as "left", // Alinhar labels à esquerda no eixo Y (estruturas)
        style: {
          fontSize: "8px", // Tamanho da fonte dos labels do eixo Y
        },
      },
    },
    tooltip: {
      y: {
        formatter: (val: number) => (val === 0 ? "Sem Dados" : `${val}%`), // Tooltip vazio para 0%
      },
    },
    legend: {
      position: "top" as const,
      fontSize: "8px", // Tamanho da fonte da legenda
    },
    fill: {
      type: "solid", // Usando tipo sólido para evitar problemas de compatibilidade
    },
  };

  return (
    <Chart
      options={options}
      series={chartData.series}
      type="bar"
      height="1000"
      width="933" // Expandir um terço do tamanho atual
    />
  );
};

export default BarChart;
