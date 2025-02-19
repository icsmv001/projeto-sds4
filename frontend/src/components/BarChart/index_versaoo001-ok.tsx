import axios from "axios";
import React, { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { LogProcesso } from "types/LogProcesso";
import { round } from "utils/format";
import { BASE_URL } from "utils/requests";

//ate aqui funcinou 100%, sem os ajustes...

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
      //  .get(`${BASE_URL}/sales/success-by-seller`)

      .get(`${BASE_URL}/LogDashBoardProcessamentos2/SUM7DIAS`)

      .then((response) => {
        const data = response.data as LogProcesso[];
        const myLabels = data.map((x) => x.nm_ESTRUTURA);
        const mySeries = data.map((x) =>
          round((100.0 * Number(x.regcorretos)) / Number(x.totalregistros), 1)
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
