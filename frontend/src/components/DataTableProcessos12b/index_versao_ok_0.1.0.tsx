import axios from "axios";
import Pagination3 from "components/Pagination3";
import React, { useEffect, useState } from "react";
import { LogProcessoPage } from "types/LogProcesso";
import { BASE_URL } from "utils/requests";

// Ajustando o componente para receber props
type DataTableProcessos12bProps = {
  id_estrutura: string | null; // Pode ser null se não for passado
  data: string | null; // Pode ser null se não for passado
};

const DataTableProcessos12b: React.FC<DataTableProcessos12bProps> = ({
  id_estrutura,
  data,
}) => {
  const [activePage, setActivePage] = useState(0);
  const [page, setPage] = useState<LogProcessoPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  // Chamada da API com os parâmetros passados via props
  useEffect(() => {
    if (id_estrutura && data) {
      // Certifique-se de que os parâmetros não são nulos

      axios
        .get(
          `${BASE_URL}/LogDashBoardProcessamentosPage/buscarDetalhamentoPorParametros?page=${activePage}&size=300&id_estrutura=${id_estrutura}&data=${data}`
        )
        .then((response) => {
          console.log("Full response:", response.data);
          setPage(response.data);
        })
        .catch((error) => {
          console.error("Error fetching data:", error);
        });
    }
  }, [activePage, id_estrutura, data]);

  // Função que recebe os argumentos de paginação
  const changePage = (index: number) => {
    setActivePage(index);
  };

  // Pegue a primeira linha do array
  const firstRow = page.content?.[0] || null;

  // Filtre os registros excluindo o primeiro
  const remainingRows = page.content?.slice(0) || [];

  return (
    <>
      <Pagination3 page={page} onPageChange={changePage} />
      <div className="table-responsive">
        {/* Renderizando o primeiro registro da lista */}
        {firstRow && (
          <table className="table table-striped table-sm">
            <thead>
              <tr>
                <th style={{ width: "35%" }}>id_cliente</th>
                <th style={{ width: "35%" }}>nm_cliente</th>
                <th style={{ width: "35%" }}>id_contrato</th>
                <th style={{ width: "35%" }}>nm_contrato</th>
                <th style={{ width: "35%" }}>segmento</th>
                <th style={{ width: "35%" }}>local_arquivo</th>
                <th style={{ width: "35%" }}>ano_mes</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{firstRow.id_CLIENTE || "N/A"}</td>
                <td>{firstRow.nm_CLIENTE || "N/A"}</td>
                <td>{firstRow.id_CONTRATO || "N/A"}</td>
                <td>{firstRow.nm_CONTRATO || "N/A"}</td>
                <td>{firstRow.segmento || "N/A"}</td>
                <td>{firstRow.local_ARQUIVO || "N/A"}</td>
                <td>{firstRow.ano_MES || "N/A"}</td>
              </tr>
            </tbody>
          </table>
        )}

        {/* Renderizando todos os registros restantes, exceto o primeiro */}
        {remainingRows.length > 0 && (
          <table className="table table-striped table-sm">
            <thead>
              <tr>
                <th>indece</th>
                <th>id_estrutura</th>
                <th>sigla</th>
                <th>tipo_carga</th>
                <th>data_calendario</th>
                <th>hora</th>
                <th>status_log</th>
                <th>totalregistros</th>
                <th>corretos</th>
                <th>incorretos</th>
                <th>vencidos</th>
                <th>%_correto</th>
                <th>%_incorreto</th>
                <th>percentual_vencidos</th>
                <th>tratado_SN</th>
                <th>regenvinclusao</th>
                <th>regenvalteracao</th>
                <th>regenvcancelamento</th>
                <th>nm_estrutura</th>
                <th>id_cliente</th>
                <th>nm_cliente</th>
                <th>id_contrato</th>
                <th>nm_contrato</th>
                <th>segmento</th>
                <th>local_arquivo</th>
                <th>ano_mes</th>
              </tr>
            </thead>
            <tbody>
              {remainingRows.map((item: any, index: number) => (
                <tr key={index}>
                  <td>{item.indece}</td>
                  <td>{item.id_ESTRUTURA}</td>
                  <td>{item.sigla}</td>
                  <td>{item.tipo_CARGA}</td>
                  <td>{item.data_CALENDARIO}</td>
                  <td>{item.hora}</td>
                  <td>{item.status_LOG}</td>
                  <td>{item.totalregistros}</td>
                  <td>{item.regcorretos}</td>
                  <td>{item.regincorretos}</td>
                  <td>{item.regenvvencido}</td>
                  <td>{item.percentual_CORRETO}</td>
                  <td>{item.percentual_INCORRETO}</td>
                  <td>{item.percentual_VENCIDOS}</td>
                  <td>{item.tratado_SN}</td>
                  <td>{item.regenvinclusao}</td>
                  <td>{item.regenvalteracao}</td>
                  <td>{item.regenvcancelamento}</td>
                  <td>{item.nm_ESTRUTURA}</td>
                  <td>{item.id_CLIENTE}</td>
                  <td>{item.nm_CLIENTE}</td>
                  <td>{item.id_CONTRATO}</td>
                  <td>{item.nm_CONTRATO}</td>
                  <td>{item.segmento}</td>
                  <td>{item.local_ARQUIVO}</td>
                  <td>{item.ano_MES}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </>
  );
};

export default DataTableProcessos12b;
