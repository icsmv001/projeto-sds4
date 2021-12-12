import axios from "axios";
import React, { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSum } from "types/sale";
import { BASE_URL } from "utils/requests";

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

  // instanciar um dado basico para o typo ChartData
  //let chartData: ChartData = { labels: [], series: [] };

  useEffect(() => {
    // axios.get("http://localhost:8080/sales/amount-by-seller")
    axios
      .get(`${BASE_URL}/sales/amount-by-seller`)

      .then((response) => {
        //axios.get("${}http://localhost:8080/sales/amount-by-seller").then((response) => {
        const data = response.data as SaleSum[];
        const myLabels = data.map((x) => x.sellerName);
        const mySeries = data.map((x) => x.sum);

        setChartData({ labels: myLabels, series: mySeries });

        //console.log(response.data);
        console.log(setChartData);
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
