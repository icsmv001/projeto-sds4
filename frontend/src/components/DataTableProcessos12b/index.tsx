import axios from "axios";
import Pagination3 from "components/Pagination3";
import React, { useEffect, useState } from "react";
import { LogProcessoPage } from "types/LogProcesso";
import { BASE_URL } from "utils/requests";
import Tooltip from "react-tooltip-lite";

type DataTableProcessos12bProps = {
  id_estrutura: string | null;
  data: string | null;
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

  const [selectedRow, setSelectedRow] = useState<number | null>(null);
  const [editRow, setEditRow] = useState<number | null>(null);
  const [inputValue, setInputValue] = useState("");

  const getTratadoLabel = (value: number) => {
    switch (value) {
      case 0:
        return "SIM";
      case 1:
        return "NÃO";
      case 2:
        return "EM ANÁLISE";
      default:
        return "";
    }
  };

  const handleRowClick = (index: number) => {
    setSelectedRow(index); // Define a linha clicada como selecionada
  };

  const handleDoubleClick = (index: number, tratado_sn: number) => {
    setEditRow(index);
    setInputValue(String(tratado_sn));
  };

  const handleSave = (id: number) => {
    console.log(`ID Sequencia: ${id}, Tratado_SN: ${inputValue}`);
    setEditRow(null);
  };

  useEffect(() => {
    if (id_estrutura && data) {
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

  const changePage = (index: number) => {
    setActivePage(index);
  };

  const firstRow = page.content?.[0] || null;
  const remainingRows = page.content?.slice(1) || [];

  return (
    <>
      <Pagination3 page={page} onPageChange={changePage} />
      <div className="table-responsive">
        {firstRow && (
          <table className="table table-striped table-sm">
            <thead>
              <tr>
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
              </tr>
            </thead>
            <tbody>
              {remainingRows.map((item: any, index: number) => (
                <tr
                  key={index}
                  onClick={() => handleRowClick(index)} // Evento de clique na linha
                  style={{
                    backgroundColor:
                      selectedRow === index ? "#e0f7fa" : "white", // Alterando a cor da linha selecionada
                    cursor: "pointer", // Estilo de cursor
                  }}
                >
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
                  <td
                    onDoubleClick={() =>
                      handleDoubleClick(index, item.tratado_SN)
                    }
                    style={{ cursor: "pointer" }}
                  >
                    {editRow === index ? (
                      <input
                        type="text"
                        value={inputValue}
                        onChange={(e) => setInputValue(e.target.value)}
                        onBlur={() => handleSave(item.id_ESTRUTURA)}
                      />
                    ) : (
                      getTratadoLabel(item.tratado_SN)
                    )}
                  </td>
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
