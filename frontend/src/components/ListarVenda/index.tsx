import axios from "axios";
import React, { useEffect, useState } from "react";
import { Sale } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const ListarVenda = () => {
  // const [Vendas, setVendas] = useState({});

  // type RetornoDados = {
  //   Vendas: number[];
  //   Vendedores: string[];
  // };

  // let retornoDados: RetornoDados = { Vendas: [], Vendedores: [] };

  // chamada da api
  // useEffect(() => {
  //   axios.get(`${BASE_URL}/sales/vendas`)
  //     .then((response) => {
  //     setVendas(response.data);

  //     const data = response.data as Sale[];
  //     const myVendas = data.map((x) => x.amount);
  //     const myVendedor = data.map((x) => x.seller.name);

  //     // eslint-disable-next-line react-hooks/exhaustive-deps
  //     const retornoDados = { Vendas: myVendas, Vendedores: myVendedor };
  //     console.log(retornoDados);

  //     // console.log("retorno - teste " + response.data);
  //   });
  // }, [Vendas]);

  const [vendas, setvendas] = useState([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/vendas`).then((response) => {
      setvendas(response.data);
    });
  }, []);

  return (
    <>
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>Data</th>
              <th>Vendedor</th>
              <th>Visitas</th>
              <th>Vendas</th>
              <th>TotVendas</th>
            </tr>
          </thead>
          <tbody>
            {vendas.map((item: any) => (
              <tr key={(item.id = 10)}>
                <td>{formatLocalDate(item.date, "dd/MM/yyyy")}</td>
                <td>{item.seller.name}</td>
                <td>{item.visited}</td>
                <td>{item.deals}</td>
                <td>{item.amount.toFixed(2)}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default ListarVenda;
