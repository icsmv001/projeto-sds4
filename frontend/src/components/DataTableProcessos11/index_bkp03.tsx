import React from "react";

class DataTableProcessos11 extends React.Component {
  render() {
    // Array de objetos contendo as datas, valores e produtos
    const data: { date: string; values: { [key: string]: number } }[] = [
      { date: "01/01/2022", values: { "Produto A": 100, "Produto B": 150 } },
      { date: "02/01/2022", values: { "Produto A": 101, "Produto B": 333 } },
      { date: "03/01/2022", values: { "Produto A": 323, "Produto B": 45 } },
      { date: "04/01/2022", values: { "Produto A": 0, "Produto B": 0 } },
      { date: "05/01/2022", values: { "Produto A": 100, "Produto B": 150 } },
      { date: "06/01/2022", values: { "Produto A": 101, "Produto B": 333 } },
      { date: "07/01/2022", values: { "Produto A": 323, "Produto B": 45 } },
      { date: "08/01/2022", values: { "Produto A": 0, "Produto B": 0 } },
      { date: "09/01/2022", values: { "Produto A": 100, "Produto B": 150 } },
      { date: "10/01/2022", values: { "Produto A": 101, "Produto B": 333 } },
      { date: "11/01/2022", values: { "Produto A": 323, "Produto B": 45 } },
      { date: "12/01/2022", values: { "Produto A": 0, "Produto B": 0 } },
      { date: "13/01/2022", values: { "Produto A": 100, "Produto B": 150 } },
      { date: "14/01/2022", values: { "Produto A": 101, "Produto B": 333 } },
      { date: "15/01/2022", values: { "Produto A": 323, "Produto B": 45 } },
      { date: "16/01/2022", values: { "Produto A": 0, "Produto B": 0 } },
      { date: "17/01/2022", values: { "Produto A": 100, "Produto B": 150 } },
      { date: "18/01/2022", values: { "Produto A": 101, "Produto B": 333 } },
      { date: "19/01/2022", values: { "Produto A": 323, "Produto B": 45 } },
      { date: "20/01/2022", values: { "Produto A": 0, "Produto B": 0 } },
      { date: "21/01/2022", values: { "Produto A": 100, "Produto B": 150 } },
      { date: "22/01/2022", values: { "Produto A": 101, "Produto B": 333 } },
      { date: "23/01/2022", values: { "Produto A": 323, "Produto B": 45 } },
      { date: "24/01/2022", values: { "Produto A": 0, "Produto B": 0 } },
      { date: "25/01/2022", values: { "Produto A": 100, "Produto B": 150 } },
      { date: "26/01/2022", values: { "Produto A": 101, "Produto B": 333 } },
      { date: "27/01/2022", values: { "Produto A": 323, "Produto B": 45 } },
      { date: "28/01/2022", values: { "Produto A": 0, "Produto B": 0 } },
      { date: "29/01/2022", values: { "Produto A": 100, "Produto B": 150 } },
      { date: "30/01/2022", values: { "Produto A": 101, "Produto B": 333 } },
      { date: "31/01/2022", values: { "Produto A": 323, "Produto B": 45 } },
      { date: "01/02/2022", values: { "Produto A": 0, "Produto B": 0 } },
      // Adicione mais dados conforme necessário...
    ];

    // Extrair todas as datas
    const dates = data.map((entry) => entry.date);
    // Extrair todos os produtos
    const products = Object.keys(data[0].values);

    return (
      <div>
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>Cronograma</th>
              {dates.map((date) => (
                <th key={date}>{date}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Produtos</td>
              {dates.map((date) => (
                <td key={date}>Quantidade</td>
              ))}
            </tr>
            {products.map((product) => (
              <tr key={product}>
                <td>{product}</td>
                {dates.map((date) => (
                  <td key={date}>
                    {data.find((entry) => entry.date === date)?.values[product]}
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default DataTableProcessos11;
