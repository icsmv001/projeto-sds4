import axios from "axios";
import React, { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { LogProcesso } from "types/LogProcesso";
import { BASE_URL } from "utils/requests";
import { round } from "utils/format";

// tipo que tera os tipos de dados do grafico
type ChartData = {
  labels: string[];
  series: number[];
};

const DonutChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: [],
    series: [],
  });

  useEffect(() => {
    axios
      .get(`${BASE_URL}/LogDashBoardProcessamentos2/SUM7DIAS`)
      .then((response) => {
        const data = response.data as LogProcesso[];
        const myLabels = data.map((x) => x.nm_ESTRUTURA);
        const mySeries = data.map((x) => Number(x.regincorretos));

        setChartData({ labels: myLabels, series: mySeries });

        console.log(mySeries);
      })

      .catch((error) => {
        console.error("Erro ao obter os dados:", error);
      });
  }, []);

  // converte a lista de objetos de retorno da API, para 2 colocoes/listas para o grafico.

  //axios.get("${BASE_URL}/sales/amount-by-seller").then((response) => {
  //    console.log(response.data);
  //});

  //const mockData = {
  //  series: [477138, 499928, 444867, 220426, 473088],
  //  labels: ["Anakin", "Barry Allen", "Kal-El", "Logan", "Padmé"],
  //};

  const options = {
    legend: {
      show: true,
    },
  };

  return (
    <Chart
      //  options={{ ...options, labels: mockData.labels }}
      //  series={mockData.series}

      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height="240"
    />
  );
};

export default DonutChart;
