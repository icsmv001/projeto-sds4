import React from "react";

class DataTableProcessos11 extends React.Component {
  render() {
    // Array de objetos contendo as datas, valores e produtos
    const data: { date: string; values: { [key: string]: number } }[] = [
      {
        date: "01/01/2024",
        values: {
          "Produto A": 100,
          "Produto B": 150,
          "Produto C": 150,
          "Produto D": 150,
          "Produto E": 150,
          "Produto F": 150,
          "Produto G": 150,
          "Produto H": 150,
          "Produto I": 150,
          "Produto J": 150,
          "Produto K": 150,
          "Produto L": 150,
          "Produto M": 150,
          "Produto N": 150,
          "Produto O": 150,
          "Produto P": 150,
          "Produto Q": 150,
          "Produto R": 150,
          "Produto S": 150,
        },
      },
      {
        date: "02/01/2024",
        values: {
          "Produto A": 101,
          "Produto B": 333,
          "Produto C": 333,
          "Produto D": 333,
          "Produto E": 333,
          "Produto F": 333,
          "Produto G": 333,
          "Produto H": 333,
          "Produto I": 333,
          "Produto J": 333,
          "Produto K": 333,
          "Produto L": 333,
          "Produto M": 333,
          "Produto N": 333,
          "Produto O": 333,
          "Produto P": 333,
          "Produto Q": 333,
          "Produto R": 333,
          "Produto S": 333,
        },
      },
      {
        date: "03/01/2024",
        values: {
          "Produto A": 323,
          "Produto B": 45,
          "Produto C": 45,
          "Produto D": 45,
          "Produto E": 45,
          "Produto F": 45,
          "Produto G": 45,
          "Produto H": 45,
          "Produto I": 45,
          "Produto J": 45,
          "Produto K": 45,
          "Produto L": 45,
          "Produto M": 45,
          "Produto N": 45,
          "Produto O": 45,
          "Produto P": 45,
          "Produto Q": 45,
          "Produto R": 45,
          "Produto S": 45,
        },
      },
      {
        date: "04/01/2024",
        values: {
          "Produto A": 0,
          "Produto B": 0,
          "Produto C": 0,
          "Produto D": 0,
          "Produto E": 0,
          "Produto F": 0,
          "Produto G": 0,
          "Produto H": 0,
          "Produto I": 0,
          "Produto J": 0,
          "Produto K": 0,
          "Produto L": 0,
          "Produto M": 0,
          "Produto N": 0,
          "Produto O": 0,
          "Produto P": 0,
          "Produto Q": 0,
          "Produto R": 0,
          "Produto S": 0,
        },
      },
      {
        date: "05/01/2024",
        values: {
          "Produto A": 100,
          "Produto B": 150,
          "Produto C": 150,
          "Produto D": 150,
          "Produto E": 150,
          "Produto F": 150,
          "Produto G": 150,
          "Produto H": 150,
          "Produto I": 150,
          "Produto J": 150,
          "Produto K": 150,
          "Produto L": 150,
          "Produto M": 150,
          "Produto N": 150,
          "Produto O": 150,
          "Produto P": 150,
          "Produto Q": 150,
          "Produto R": 150,
          "Produto S": 150,
        },
      },
      {
        date: "06/01/2024",
        values: {
          "Produto A": 101,
          "Produto B": 333,
          "Produto C": 333,
          "Produto D": 333,
          "Produto E": 333,
          "Produto F": 333,
          "Produto G": 333,
          "Produto H": 333,
          "Produto I": 333,
          "Produto J": 333,
          "Produto K": 333,
          "Produto L": 333,
          "Produto M": 333,
          "Produto N": 333,
          "Produto O": 333,
          "Produto P": 333,
          "Produto Q": 333,
          "Produto R": 333,
          "Produto S": 333,
        },
      },
      {
        date: "07/01/2024",
        values: {
          "Produto A": 323,
          "Produto B": 45,
          "Produto C": 45,
          "Produto D": 45,
          "Produto E": 45,
          "Produto F": 45,
          "Produto G": 45,
          "Produto H": 45,
          "Produto I": 45,
          "Produto J": 45,
          "Produto K": 45,
          "Produto L": 45,
          "Produto M": 45,
          "Produto N": 45,
          "Produto O": 45,
          "Produto P": 45,
          "Produto Q": 45,
          "Produto R": 45,
          "Produto S": 45,
        },
      },
      {
        date: "08/01/2024",
        values: {
          "Produto A": 0,
          "Produto B": 0,
          "Produto C": 0,
          "Produto D": 0,
          "Produto E": 0,
          "Produto F": 0,
          "Produto G": 0,
          "Produto H": 0,
          "Produto I": 0,
          "Produto J": 0,
          "Produto K": 0,
          "Produto L": 0,
          "Produto M": 0,
          "Produto N": 0,
          "Produto O": 0,
          "Produto P": 0,
          "Produto Q": 0,
          "Produto R": 0,
          "Produto S": 0,
        },
      },
      {
        date: "09/01/2024",
        values: {
          "Produto A": 100,
          "Produto B": 150,
          "Produto C": 150,
          "Produto D": 150,
          "Produto E": 150,
          "Produto F": 150,
          "Produto G": 150,
          "Produto H": 150,
          "Produto I": 150,
          "Produto J": 150,
          "Produto K": 150,
          "Produto L": 150,
          "Produto M": 150,
          "Produto N": 150,
          "Produto O": 150,
          "Produto P": 150,
          "Produto Q": 150,
          "Produto R": 150,
          "Produto S": 150,
        },
      },
      {
        date: "10/01/2024",
        values: {
          "Produto A": 101,
          "Produto B": 333,
          "Produto C": 333,
          "Produto D": 333,
          "Produto E": 333,
          "Produto F": 333,
          "Produto G": 333,
          "Produto H": 333,
          "Produto I": 333,
          "Produto J": 333,
          "Produto K": 333,
          "Produto L": 333,
          "Produto M": 333,
          "Produto N": 333,
          "Produto O": 333,
          "Produto P": 333,
          "Produto Q": 333,
          "Produto R": 333,
          "Produto S": 333,
        },
      },
      {
        date: "11/01/2024",
        values: {
          "Produto A": 323,
          "Produto B": 45,
          "Produto C": 45,
          "Produto D": 45,
          "Produto E": 45,
          "Produto F": 45,
          "Produto G": 45,
          "Produto H": 45,
          "Produto I": 45,
          "Produto J": 45,
          "Produto K": 45,
          "Produto L": 45,
          "Produto M": 45,
          "Produto N": 45,
          "Produto O": 45,
          "Produto P": 45,
          "Produto Q": 45,
          "Produto R": 45,
          "Produto S": 45,
        },
      },
      {
        date: "12/01/2024",
        values: {
          "Produto A": 0,
          "Produto B": 0,
          "Produto C": 0,
          "Produto D": 0,
          "Produto E": 0,
          "Produto F": 0,
          "Produto G": 0,
          "Produto H": 0,
          "Produto I": 0,
          "Produto J": 0,
          "Produto K": 0,
          "Produto L": 0,
          "Produto M": 0,
          "Produto N": 0,
          "Produto O": 0,
          "Produto P": 0,
          "Produto Q": 0,
          "Produto R": 0,
          "Produto S": 0,
        },
      },
      {
        date: "13/01/2024",
        values: {
          "Produto A": 100,
          "Produto B": 150,
          "Produto C": 150,
          "Produto D": 150,
          "Produto E": 150,
          "Produto F": 150,
          "Produto G": 150,
          "Produto H": 150,
          "Produto I": 150,
          "Produto J": 150,
          "Produto K": 150,
          "Produto L": 150,
          "Produto M": 150,
          "Produto N": 150,
          "Produto O": 150,
          "Produto P": 150,
          "Produto Q": 150,
          "Produto R": 150,
          "Produto S": 150,
        },
      },
      {
        date: "14/01/2024",
        values: {
          "Produto A": 101,
          "Produto B": 333,
          "Produto C": 333,
          "Produto D": 333,
          "Produto E": 333,
          "Produto F": 333,
          "Produto G": 333,
          "Produto H": 333,
          "Produto I": 333,
          "Produto J": 333,
          "Produto K": 333,
          "Produto L": 333,
          "Produto M": 333,
          "Produto N": 333,
          "Produto O": 333,
          "Produto P": 333,
          "Produto Q": 333,
          "Produto R": 333,
          "Produto S": 333,
        },
      },
      {
        date: "15/01/2024",
        values: {
          "Produto A": 323,
          "Produto B": 450,
          "Produto C": 450,
          "Produto D": 450,
          "Produto E": 450,
          "Produto F": 450,
          "Produto G": 450,
          "Produto H": 450,
          "Produto I": 450,
          "Produto J": 450,
          "Produto K": 450,
          "Produto L": 450,
          "Produto M": 450,
          "Produto N": 450,
          "Produto O": 450,
          "Produto P": 450,
          "Produto Q": 450,
          "Produto R": 450,
          "Produto S": 450,
        },
      },
      {
        date: "16/01/2024",
        values: {
          "Produto A": 0,
          "Produto B": 0,
          "Produto C": 0,
          "Produto D": 0,
          "Produto E": 0,
          "Produto F": 0,
          "Produto G": 0,
          "Produto H": 0,
          "Produto I": 0,
          "Produto J": 0,
          "Produto K": 0,
          "Produto L": 0,
          "Produto M": 0,
          "Produto N": 0,
          "Produto O": 0,
          "Produto P": 0,
          "Produto Q": 0,
          "Produto R": 0,
          "Produto S": 0,
        },
      },
      {
        date: "17/01/2024",
        values: {
          "Produto A": 100,
          "Produto B": 150,
          "Produto C": 150,
          "Produto D": 150,
          "Produto E": 150,
          "Produto F": 150,
          "Produto G": 150,
          "Produto H": 150,
          "Produto I": 150,
          "Produto J": 150,
          "Produto K": 150,
          "Produto L": 150,
          "Produto M": 150,
          "Produto N": 150,
          "Produto O": 150,
          "Produto P": 150,
          "Produto Q": 150,
          "Produto R": 150,
          "Produto S": 150,
        },
      },
      {
        date: "18/01/2024",
        values: {
          "Produto A": 101,
          "Produto B": 333,
          "Produto C": 333,
          "Produto D": 333,
          "Produto E": 333,
          "Produto F": 333,
          "Produto G": 333,
          "Produto H": 333,
          "Produto I": 333,
          "Produto J": 333,
          "Produto K": 333,
          "Produto L": 333,
          "Produto M": 333,
          "Produto N": 333,
          "Produto O": 333,
          "Produto P": 333,
          "Produto Q": 333,
          "Produto R": 333,
          "Produto S": 333,
        },
      },
      {
        date: "19/01/2024",
        values: {
          "Produto A": 323,
          "Produto B": 450,
          "Produto C": 450,
          "Produto D": 450,
          "Produto E": 450,
          "Produto F": 450,
          "Produto G": 450,
          "Produto H": 450,
          "Produto I": 450,
          "Produto J": 450,
          "Produto K": 450,
          "Produto L": 450,
          "Produto M": 450,
          "Produto N": 450,
          "Produto O": 450,
          "Produto P": 450,
          "Produto Q": 450,
          "Produto R": 450,
          "Produto S": 450,
        },
      },
      {
        date: "20/01/2024",
        values: {
          "Produto A": 0,
          "Produto B": 0,
          "Produto C": 0,
          "Produto D": 0,
          "Produto E": 0,
          "Produto F": 0,
          "Produto G": 0,
          "Produto H": 0,
          "Produto I": 0,
          "Produto J": 0,
          "Produto K": 0,
          "Produto L": 0,
          "Produto M": 0,
          "Produto N": 0,
          "Produto O": 0,
          "Produto P": 0,
          "Produto Q": 0,
          "Produto R": 0,
          "Produto S": 0,
        },
      },
      {
        date: "21/01/2024",
        values: {
          "Produto A": 100,
          "Produto B": 150,
          "Produto C": 150,
          "Produto D": 150,
          "Produto E": 150,
          "Produto F": 150,
          "Produto G": 150,
          "Produto H": 150,
          "Produto I": 150,
          "Produto J": 150,
          "Produto K": 150,
          "Produto L": 150,
          "Produto M": 150,
          "Produto N": 150,
          "Produto O": 150,
          "Produto P": 150,
          "Produto Q": 150,
          "Produto R": 150,
          "Produto S": 150,
        },
      },
      {
        date: "22/01/2024",
        values: {
          "Produto A": 101,
          "Produto B": 333,
          "Produto C": 333,
          "Produto D": 333,
          "Produto E": 333,
          "Produto F": 333,
          "Produto G": 333,
          "Produto H": 333,
          "Produto I": 333,
          "Produto J": 333,
          "Produto K": 333,
          "Produto L": 333,
          "Produto M": 333,
          "Produto N": 333,
          "Produto O": 333,
          "Produto P": 333,
          "Produto Q": 333,
          "Produto R": 333,
          "Produto S": 333,
        },
      },
      {
        date: "23/01/2024",
        values: {
          "Produto A": 323,
          "Produto B": 405,
          "Produto C": 405,
          "Produto D": 405,
          "Produto E": 405,
          "Produto F": 405,
          "Produto G": 405,
          "Produto H": 405,
          "Produto I": 405,
          "Produto J": 405,
          "Produto K": 405,
          "Produto L": 405,
          "Produto M": 405,
          "Produto N": 405,
          "Produto O": 405,
          "Produto P": 405,
          "Produto Q": 405,
          "Produto R": 405,
          "Produto S": 405,
        },
      },
      {
        date: "24/01/2024",
        values: {
          "Produto A": 0,
          "Produto B": 0,
          "Produto C": 0,
          "Produto D": 0,
          "Produto E": 0,
          "Produto F": 0,
          "Produto G": 0,
          "Produto H": 0,
          "Produto I": 0,
          "Produto J": 0,
          "Produto K": 0,
          "Produto L": 0,
          "Produto M": 0,
          "Produto N": 0,
          "Produto O": 0,
          "Produto P": 0,
          "Produto Q": 0,
          "Produto R": 0,
          "Produto S": 0,
        },
      },
      {
        date: "25/01/2024",
        values: {
          "Produto A": 100,
          "Produto B": 150,
          "Produto C": 150,
          "Produto D": 150,
          "Produto E": 150,
          "Produto F": 150,
          "Produto G": 150,
          "Produto H": 150,
          "Produto I": 150,
          "Produto J": 150,
          "Produto K": 150,
          "Produto L": 150,
          "Produto M": 150,
          "Produto N": 150,
          "Produto O": 150,
          "Produto P": 150,
          "Produto Q": 150,
          "Produto R": 150,
          "Produto S": 150,
        },
      },
      {
        date: "26/01/2024",
        values: {
          "Produto A": 101,
          "Produto B": 333,
          "Produto C": 333,
          "Produto D": 333,
          "Produto E": 333,
          "Produto F": 333,
          "Produto G": 333,
          "Produto H": 333,
          "Produto I": 333,
          "Produto J": 333,
          "Produto K": 333,
          "Produto L": 333,
          "Produto M": 333,
          "Produto N": 333,
          "Produto O": 333,
          "Produto P": 333,
          "Produto Q": 333,
          "Produto R": 333,
          "Produto S": 333,
        },
      },
      {
        date: "27/01/2024",
        values: {
          "Produto A": 323,
          "Produto B": 405,
          "Produto C": 405,
          "Produto D": 405,
          "Produto E": 405,
          "Produto F": 405,
          "Produto G": 405,
          "Produto H": 405,
          "Produto I": 405,
          "Produto J": 405,
          "Produto K": 405,
          "Produto L": 405,
          "Produto M": 405,
          "Produto N": 405,
          "Produto O": 405,
          "Produto P": 405,
          "Produto Q": 405,
          "Produto R": 405,
          "Produto S": 405,
        },
      },
      {
        date: "28/01/2024",
        values: {
          "Produto A": 0,
          "Produto B": 0,
          "Produto C": 0,
          "Produto D": 0,
          "Produto E": 0,
          "Produto F": 0,
          "Produto G": 0,
          "Produto H": 0,
          "Produto I": 0,
          "Produto J": 0,
          "Produto K": 0,
          "Produto L": 0,
          "Produto M": 0,
          "Produto N": 0,
          "Produto O": 0,
          "Produto P": 0,
          "Produto Q": 0,
          "Produto R": 0,
          "Produto S": 0,
        },
      },
      {
        date: "29/01/2024",
        values: {
          "Produto A": 100,
          "Produto B": 150,
          "Produto C": 150,
          "Produto D": 150,
          "Produto E": 150,
          "Produto F": 150,
          "Produto G": 150,
          "Produto H": 150,
          "Produto I": 150,
          "Produto J": 150,
          "Produto K": 150,
          "Produto L": 150,
          "Produto M": 150,
          "Produto N": 150,
          "Produto O": 150,
          "Produto P": 150,
          "Produto Q": 150,
          "Produto R": 150,
          "Produto S": 150,
        },
      },
      {
        date: "30/01/2024",
        values: {
          "Produto A": 101,
          "Produto B": 333,
          "Produto C": 333,
          "Produto D": 333,
          "Produto E": 333,
          "Produto F": 333,
          "Produto G": 333,
          "Produto H": 333,
          "Produto I": 333,
          "Produto J": 333,
          "Produto K": 333,
          "Produto L": 333,
          "Produto M": 333,
          "Produto N": 333,
          "Produto O": 333,
          "Produto P": 333,
          "Produto Q": 333,
          "Produto R": 333,
          "Produto S": 333,
        },
      },
      {
        date: "31/01/2024",
        values: {
          "Produto A": 323,
          "Produto B": 405,
          "Produto C": 405,
          "Produto D": 405,
          "Produto E": 405,
          "Produto F": 405,
          "Produto G": 405,
          "Produto H": 405,
          "Produto I": 405,
          "Produto J": 405,
          "Produto K": 405,
          "Produto L": 405,
          "Produto M": 405,
          "Produto N": 405,
          "Produto O": 405,
          "Produto P": 405,
          "Produto Q": 405,
          "Produto R": 405,
          "Produto S": 405,
        },
      },
      {
        date: "01/02/2024",
        values: {
          "Produto A": 0,
          "Produto B": 0,
          "Produto C": 0,
          "Produto D": 0,
          "Produto E": 0,
          "Produto F": 0,
          "Produto G": 0,
          "Produto H": 0,
          "Produto I": 0,
          "Produto J": 0,
          "Produto K": 0,
          "Produto L": 0,
          "Produto M": 0,
          "Produto N": 0,
          "Produto O": 0,
          "Produto P": 0,
          "Produto Q": 0,
          "Produto R": 0,
          "Produto S": 0,
        },
      },

      // Adicione mais dados conforme necessário...
    ];

    // Extrair todas as datas
    const dates = data.map((entry) => entry.date);
    // Extrair todos os produtos
    const products = Object.keys(data[0].values);

    return (
      <div style={{ overflowX: "auto" }}>
        <table
          className="table table-striped table-sm"
          style={{ minWidth: "800px" }}
        >
          <thead>
            <tr>
              <th>Cronograma</th>
              {dates.map((date) => (
                <th key={date}>{date}</th>
              ))}
            </tr>
          </thead>
          <tbody style={{ maxHeight: "400", overflowY: "auto" }}>
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
