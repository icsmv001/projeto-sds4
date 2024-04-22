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
        `${BASE_URL}/LogDashBoardProcessamentosPage?page=${activePage}&size=10&sort=date,desc`
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

  const uniqueIds = page.content
    ? Array.from(new Set(page.content.map((item: any) => item.id_ESTRUTURA)))
    : [];

  const uniqueDates = page.content
    ? page.content.reduce((dates: string[], item: any) => {
        if (!dates.includes(item.data_CALENDARIO)) {
          dates.push(item.data_CALENDARIO);
        }
        return dates;
      }, [])
    : [];

  const getDataForDateAndId = (date: string, id: number): number => {
    const item = page.content?.find(
      (entry: any) =>
        entry.data_CALENDARIO === date && entry.id_ESTRUTURA === id
    );
    return item ? Number(item.totalregistros) : 0;
  };

  return (
    <>
      <Pagination3 page={page} onPageChange={changePage} />
      <div className="table-responsive" style={{ overflowX: "auto" }}>
        <table
          className="table table-striped table-sm"
          style={{ minWidth: "800px" }}
        >
          <thead>
            <tr>
              <th>CRONOGRAMA</th>
            </tr>
            <tr>
              <th style={{ width: "35%" }}>id_estrutura</th>
              <th style={{ width: "35%" }}>sigla</th>
              <th style={{ width: "35%" }}>nm_estrutura</th>
              <th style={{ width: "35%" }}>status_log</th>
              {uniqueDates.map((date, index) => (
                <th key={index}>{date}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {uniqueIds.map((id, index) => {
              const item = page.content?.find(
                (item: any) => item.id_ESTRUTURA === id
              );
              console.log("Item encontrado:", item); // Adicione este log para verificar o conteúdo do objeto item

              return (
                <tr key={index}>
                  <td style={{ width: "35%" }}>{id}</td>
                  <td style={{ width: "35%" }}>{item?.sigla}</td>
                  <td style={{ width: "35%" }}>{item?.nm_ESTRUTURA}</td>
                  <td style={{ width: "35%" }}>{item?.status_LOG}</td>
                  {uniqueDates.map((date, index) => (
                    <td key={index}>{getDataForDateAndId(date, id)}</td>
                  ))}
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default DataTableProcessos13;
