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
        `${BASE_URL}/LogDashBoardProcessamentosPage?page=${activePage}&size=500&sort=date,desc`
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

  // Extrair as siglas únicas
  const uniqueSiglas = page.content
    ? Array.from(new Set(page.content.map((item: any) => item.sigla)))
    : [];

  // Extrair os nomes de estrutura únicos
  const uniqueEstruturas = page.content
    ? Array.from(new Set(page.content.map((item: any) => item.nm_ESTRUTURA)))
    : [];

  // Extrair os status_lo únicos
  const uniqueStatusLOG = page.content
    ? Array.from(new Set(page.content.map((item: any) => item.status_LOG)))
    : [];

  // Função para obter o valor para uma data e ID específicos
  const getDataForDateAndId = (date: string, id: number): number => {
    const item = page.content?.find(
      (entry: any) =>
        entry.data_CALENDARIO === date && entry.id_ESTRUTURA === id
    );
    return item ? Number(item.totalregistros) : 0;
  };

  // Renderizar uma linha para cada ID
  const renderRows = () => {
    return uniqueIds.map((id, idIndex) => {
      return (
        <tr key={idIndex}>
          <td style={{ width: "35%" }}>{id}</td>
          <td>{uniqueSiglas[idIndex]}</td>
          <td>{uniqueEstruturas[idIndex]}</td>
          <td>{uniqueStatusLOG[idIndex]}</td>

          {uniqueDates.map((date, dateIndex) => (
            <td key={dateIndex}>{getDataForDateAndId(date, id)}</td>
          ))}
        </tr>
      );
    });
  };

  // Calcular a quantidade de linhas necessárias para exibir todos os dados
  const rowsNeeded = Math.ceil(uniqueIds.length / 15);
  const rowsToRender = rowsNeeded * 10;

  // Adicionar linhas extras, se necessário
  while (uniqueIds.length < rowsToRender) {
    uniqueIds.push("");
  }

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
              <th>sigla</th>
              <th>nm_estrutura</th>
              <th>status_log</th>
              {/* Renderizar as datas */}
              {uniqueDates.map((date, index) => (
                <th key={index}>{date}</th>
              ))}
            </tr>
          </thead>
          <tbody>{renderRows()}</tbody>
        </table>
      </div>
    </>
  );
};

export default DataTableProcessos13;
