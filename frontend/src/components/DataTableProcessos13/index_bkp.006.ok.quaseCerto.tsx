import axios from "axios";
import Pagination3 from "components/Pagination3";
import React, { useEffect, useState } from "react";
import { LogProcessoPage } from "types/LogProcesso";

import { BASE_URL } from "utils/requests";

const DataTableProcessos13 = () => {
  const [activePage, setActivePage] = useState(0);
  const [page, setPage] = useState<LogProcessoPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
    content: [],
  });

  useEffect(() => {
    axios
      .get(
        `${BASE_URL}/LogDashBoardProcessamentosPage?page=${activePage}&size=15&sort=date,desc`
      )
      .then((response) => {
        setPage(response.data);
      })
      .catch((error) => {
        console.error("Erro ao obter os dados:", error);
      });
  }, [activePage]);

  const changePage = (index: number) => {
    setActivePage(index);
  };

  // Extrair as IDs únicas
  const uniqueIds = page.content
    ? Array.from(new Set(page.content.map((item: any) => item.id_ESTRUTURA)))
    : [];

  // Extrair as datas únicas
  const uniqueDates = page.content
    ? Array.from(new Set(page.content.map((item: any) => item.data_CALENDARIO)))
    : [];

  // Função para obter o valor para uma data e ID específicos
  const getDataForDateAndId = (date: string, id: number): number => {
    const item = page.content?.find(
      (entry: any) =>
        entry.data_CALENDARIO === date && entry.id_ESTRUTURA === id
    );
    return item ? Number(item.totalregistros) : 0;
  };

  // Garantir que haja 15 itens renderizados, mesmo que a página tenha menos
  const renderableIds = uniqueIds.slice(0, 10);

  return (
    <>
      <Pagination3 page={page} onPageChange={changePage} />
      <div className="table-responsive" style={{ overflowX: "auto" }}>
        <table
          className="table table-striped table-sm"
          style={{ minWidth: "800px", overflowY: "auto" }}
        >
          <thead>
            <tr>
              <th>id_estrutura</th>
              {/* Renderizar as datas */}
              {uniqueDates.map((date, index) => (
                <th key={index}>{date}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {/* Renderizar uma linha para todas as estruturas */}
            <tr>
              {renderableIds.map((id, index) => (
                <React.Fragment key={index}>
                  <td style={{ width: "35%" }}>{id}</td>
                  {/* Para cada data, renderizar o valor correspondente */}
                  {uniqueDates.map((date, dataIndex) => (
                    <td key={dataIndex}>{getDataForDateAndId(date, id)}</td>
                  ))}
                </React.Fragment>
              ))}
            </tr>
          </tbody>
        </table>
      </div>
    </>
  );
};

export default DataTableProcessos13;
