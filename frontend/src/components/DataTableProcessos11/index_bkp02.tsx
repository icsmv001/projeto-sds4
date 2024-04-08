import axios from "axios";
import Pagination3 from "components/Pagination3";
import React, { useEffect, useState } from "react";
import { LogProcessoPage } from "types/LogProcesso";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTableProcessos11 = () => {
  const [activePage, setActivePage] = useState(0);

  const [page, setpage] = useState<LogProcessoPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  // chamada da api
  useEffect(() => {
    //axios.get("http://localhost:8080/sales?page=0&size=10&sort=date,desc")
    // comentarios,
    // no front end, o total de itens por pagina esta na linha abaixo, size=5, total de itens por pagina.
    // no backend, o total de itens por pagina default esta com size=10, ou seja se nao for informado
    //             no front end o numero de itens por pagina desejado, assume o valor default 10.
    axios
      .get(
        `${BASE_URL}/LogDashBoardProcessamentosPage?page=${activePage}&size=5&sort=date,desc`
      )
      .then((response) => {
        setpage(response.data);
      });
  }, [activePage]);

  // funcao que recebe os argumentos de paginacao
  const changePage = (index: number) => {
    setActivePage(index);
  };

  return (
    <>
      <Pagination3 page={page} onPageChange={changePage} />
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th style={{ width: "35%" }}>indece </th>
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
            {page.content?.map((item: any, indece: number) => (
              <tr key={item.indece}>
                <td style={{ width: "35%" }}>{item.indece}</td>
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

export default DataTableProcessos11;
