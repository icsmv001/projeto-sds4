import axios from "axios";
import React, { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSuccess } from "types/sale";
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
        name: "",
        data: [],
      },
    ],
  });

  useEffect(() => {
    axios
      .get(`${BASE_URL}/LogDashBoardProcessamentos2/SUM7DIAS`)

      .then((response) => {
        const data = response.data as SaleSuccess[];
        const myLabels = data.map((x) => x.sellerName);
        const mySeries = data.map((x) =>
          round((100.0 * x.deals) / x.visited, 1)
        );

        setChartData({
          labels: {
            categories: myLabels,
          },
          series: [
            {
              name: "% Success",
              data: mySeries,
            },
          ],
        });

        //console.log(response.data);
        console.log(setChartData);
      });
  }, []);

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  };

  // const mockData = {
  //   labels: {
  //     categories: ["Anakin", "Barry Allen", "Kal-El", "Logan", "Padmé"],
  //  },
  //  series: [
  //    {
  //      name: "% Sucesso",
  //      data: [43.6, 67.1, 67.7, 45.6, 71.1],
  //    },
  //  ],
  //};

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
};

export default BarChart;
