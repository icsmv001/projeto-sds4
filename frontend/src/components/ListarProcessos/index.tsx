import axios from "axios";
import React, { useEffect, useState } from "react";
// import { Sale } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";
import { LogProcesso } from "types/LogProcesso";
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

  const [LogProcesso, setProcessos] = useState([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/LogDashBoardProcessamentos2`).then((response) => {
      setProcessos(response.data);
      console.log("retorno - teste " + response.data);
    });
  }, [LogProcesso]);

  return (
    <>
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th style={{ width: "35%" }}>monitoracao </th>
              <th style={{ width: "35%" }}>id_estrutura </th>
              <th style={{ width: "35%" }}>sigla </th>
              <th style={{ width: "35%" }}>tipo_carga </th>
              <th style={{ width: "35%" }}>data_calendario </th>
              <th style={{ width: "35%" }}>hora </th>
              <th style={{ width: "35%" }}>id_seqlog </th>
              <th style={{ width: "35%" }}>status_log </th>
              <th style={{ width: "35%" }}>totalregistros </th>
              <th style={{ width: "35%" }}>regcorretos </th>
              <th style={{ width: "35%" }}>regincorretos </th>
              <th style={{ width: "35%" }}>regenvvencido </th>
              <th style={{ width: "35%" }}>percentual_correto </th>
              <th style={{ width: "35%" }}>percentual_incorreto</th>
              <th style={{ width: "35%" }}>percentual_vencidos </th>
              <th style={{ width: "35%" }}>regenvinclusao </th>
              <th style={{ width: "35%" }}>regenvalteracao </th>
              <th style={{ width: "35%" }}>regenvcancelamento </th>
              <th style={{ width: "35%" }}>nm_estrutura </th>
              <th style={{ width: "35%" }}>id_cliente </th>
              <th style={{ width: "35%" }}>nm_cliente </th>
              <th style={{ width: "35%" }}>id_contrato </th>
              <th style={{ width: "35%" }}>nm_contrato </th>
              <th style={{ width: "35%" }}>segmento </th>
              <th style={{ width: "35%" }}>local_arquivo </th>
              <th style={{ width: "35%" }}>ano_mes </th>
              <th style={{ width: "35%" }}>indece </th>
            </tr>
          </thead>
          <tbody>
            {LogProcesso.map((item: any, indece: number) => (
              <tr key={item.indece}>
                <td style={{ width: "35%" }}>{item.monitoracao}</td>
                <td style={{ width: "35%" }}>{item.id_ESTRUTURA}</td>
                <td style={{ width: "35%" }}>{item.sigla}</td>
                <td style={{ width: "35%" }}>{item.tipo_CARGA}</td>
                <td style={{ width: "35%" }}>{item.data_CALENDARIO}</td>
                <td style={{ width: "35%" }}>{item.hora}</td>
                <td style={{ width: "35%" }}>{item.id_SEQLOG}</td>
                <td style={{ width: "35%" }}>{item.status_LOG}</td>
                <td style={{ width: "35%" }}>{item.totalregistros}</td>
                <td style={{ width: "35%" }}>{item.regcorretos}</td>
                <td style={{ width: "35%" }}>{item.regincorretos}</td>
                <td style={{ width: "35%" }}>{item.regenvvencido}</td>
                <td style={{ width: "35%" }}>{item.percentual_CORRETO}</td>
                <td style={{ width: "35%" }}>{item.percentual_INCORRETO}</td>
                <td style={{ width: "35%" }}>{item.percentual_VENCIDOS}</td>
                <td style={{ width: "35%" }}>{item.regenvinclusao}</td>
                <td style={{ width: "35%" }}>{item.regenvalteracao}</td>
                <td style={{ width: "35%" }}>{item.regenvcancelamento}</td>
                <td style={{ width: "35%" }}>{item.nm_ESTRUTURA}</td>
                <td style={{ width: "35%" }}>{item.id_CLIENTE}</td>
                <td style={{ width: "35%" }}>{item.nm_CLIENTE}</td>
                <td style={{ width: "35%" }}>{item.id_CONTRATO}</td>
                <td style={{ width: "35%" }}>{item.nm_CONTRATO}</td>
                <td style={{ width: "35%" }}>{item.segmento}</td>
                <td style={{ width: "35%" }}>{item.local_ARQUIVO}</td>
                <td style={{ width: "35%" }}>{item.ano_MES}</td>
                <td style={{ width: "35%" }}>{item.indece}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default ListarProcessos;
