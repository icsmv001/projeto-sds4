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
      {
        name: "Sem Movimento", // Série para valores sem movimento
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
        const noMovementSeries = data.map(
          (x) => (Number(x.totalregistros) === 0 ? 100 : 0) // 100% para "Sem Movimento"
        );

        // Filtrar para remover itens com 100% corretos
        const filteredData = data
          .map((item, index) => ({
            label: myLabels[index],
            correct: correctSeries[index],
            incorrect: incorrectSeries[index],
            noMovement: noMovementSeries[index],
          }))
          .filter((item) => item.correct !== 100 || item.noMovement === 100);

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

  const options = {
    chart: {
      stacked: true,
    },
    plotOptions: {
      bar: {
        horizontal: true,
        barHeight: "50%", // Diminuir a largura da barra
      },
    },
    colors: ["#1616e0", "#da2424", "#ff00ff"], // Azul para corretos, vermelho para incorretos, magenta para sem movimento
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
          fontSize: "10px", // Aumentar o tamanho da fonte dos labels do eixo Y
          width: "200px", // Aumentar largura dos labels
        },
      },
    },
    tooltip: {
      y: {
        formatter: (val: number, opts: any) => {
          const seriesName = opts.w.globals.seriesNames[opts.seriesIndex];
          // Verifica se é a série "Sem Movimento" e ajusta para mostrar 0.0% em vez de 100%
          if (seriesName === "Sem Movimento" && val === 100) {
            return "0.0%";
          }
          return `${val}%`;
        },
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
