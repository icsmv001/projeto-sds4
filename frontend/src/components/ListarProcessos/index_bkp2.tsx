import axios from "axios";
import React, { useEffect, useState } from "react";
// import { Sale } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const ListarProcessos = () => {
  // const [Processoss, setProcessoss] = useState({});

  // type RetornoDados = {
  //   Processoss: number[];
  //   Vendedores: string[];
  // };

  // let retornoDados: RetornoDados = { Processoss: [], Vendedores: [] };

  // chamada da api
  // useEffect(() => {
  //   axios.get(`${BASE_URL}/sales/Processoss`)
  //     .then((response) => {
  //     setProcessoss(response.data);

  //     const data = response.data as Sale[];
  //     const myProcessoss = data.map((x) => x.amount);
  //     const myVendedor = data.map((x) => x.seller.name);

  //     // eslint-disable-next-line react-hooks/exhaustive-deps
  //     const retornoDados = { Processoss: myProcessoss, Vendedores: myVendedor };
  //     console.log(retornoDados);

  //     // console.log("retorno - teste " + response.data);
  //   });
  // }, [Processoss]);

  const [Processos, setProcessos] = useState([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/LogDashBoardProcessamentos2`).then((response) => {
      setProcessos(response.data);
      console.log("retorno - teste " + response.data);
    });
  }, []);

  return (
    <>
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>monitoracao </th>
              <th>id_estrutura </th>
              <th>sigla </th>
              <th>tipo_carga </th>
              <th>data_calendario </th>
              <th>hora </th>
              <th>id_seqlog </th>
              <th>status_log </th>
              <th>totalregistros </th>
              <th>regcorretos </th>
              <th>regincorretos </th>
              <th>regenvvencido </th>
              <th>percentual_correto </th>
              <th>percentual_incorreto</th>
              <th>percentual_vencidos </th>
              <th>regenvinclusao </th>
              <th>regenvalteracao </th>
              <th>regenvcancelamento </th>
              <th>nm_estrutura </th>
              <th>id_cliente </th>
              <th>nm_cliente </th>
              <th>id_contrato </th>
              <th>nm_contrato </th>
              <th>segmento </th>
              <th>local_arquivo </th>
              <th>ano_mes </th>
            </tr>
          </thead>
          <tbody>
            {Processos.map((item: any) => (
              <tr key={item.id_estrutura}>
                <td>{item.monitoracao}</td>
                <td>{item.id_estrutura}</td>
                <td>{item.sigla}</td>
                <td>{item.tipo_carga}</td>
                <td>{item.data_calendario}</td>
                <td>{item.hora}</td>
                <td>{item.id_seqlog}</td>
                <td>{item.status_log}</td>
                <td>{item.totalregistros}</td>
                <td>{item.regcorretos}</td>
                <td>{item.regincorretos}</td>
                <td>{item.regenvvencido}</td>
                <td>{item.percentual_correto}</td>
                <td>{item.percentual_incorreto}</td>
                <td>{item.percentual_vencidos}</td>
                <td>{item.regenvinclusao}</td>
                <td>{item.regenvalteracao}</td>
                <td>{item.regenvcancelamento}</td>
                <td>{item.nm_estrutura}</td>
                <td>{item.id_cliente}</td>
                <td>{item.nm_cliente}</td>
                <td>{item.id_contrato}</td>
                <td>{item.nm_contrato}</td>
                <td>{item.segmento}</td>
                <td>{item.local_arquivo}</td>
                <td>{item.ano_mes}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default ListarProcessos;
