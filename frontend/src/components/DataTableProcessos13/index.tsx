import axios from "axios";
import Pagination3 from "components/Pagination3";
import React, { useEffect, useState } from "react";
import { LogProcessoPage } from "types/LogProcesso";
import { BASE_URL } from "utils/requests";

// teste de mesa1--> http://localhost:8080/LogDashBoardProcessamentosPage?page=0&size=500&sort=data, desc
// teste de mesa2-->  ${BASE_URL}/LogDashBoardProcessamentosPage?page=${activePage}&size=500&sort=date,desc

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
        // Processar os dados de status_LOG para garantir que cada entrada tenha um valor
        const processedData = response.data.content.map((item: any) => ({
          ...item,
          status_LOG: item.status_LOG || "N/A",
        }));
        setPage({ ...response.data, content: processedData });
      })
      .catch((error) => {
        console.error("Erro ao obter os dados:", error);
      });
  }, [activePage]);

  const changePage = (index: number) => {
    setActivePage(index);
  };

  const uniqueIds = Array.from(
    new Set(page.content?.map((item: any) => item.id_ESTRUTURA) ?? [])
  );

  const uniqueDates = Array.from(
    new Set(page.content?.map((item: any) => item.data_CALENDARIO) ?? [])
  );

  const uniqueSiglas = Array.from(
    new Set(page.content?.map((item: any) => item.sigla) ?? [])
  );

  const uniqueEstruturas = Array.from(
    new Set(page.content?.map((item: any) => item.nm_ESTRUTURA) ?? [])
  );

  const statusLogs = uniqueIds.map((id) => {
    const item = page.content?.find((entry: any) => entry.id_ESTRUTURA === id);
    return item ? item.status_LOG : "N/A";
  });

  const getDataForDateAndId = (date: string, id: number): string => {
    const item = page.content?.find(
      (entry: any) =>
        entry.data_CALENDARIO === date && entry.id_ESTRUTURA === id
    );
    return item ? item.totalregistros : "0";
  };

  const renderRows = () => {
    return uniqueIds.map((id, idIndex) => (
      <tr key={idIndex}>
        <td>{id}</td>
        <td>{uniqueSiglas[idIndex]}</td>
        <td>{uniqueEstruturas[idIndex]}</td>
        <td>
          <span className={getStatusColor(statusLogs[idIndex])}>
            {statusLogs[idIndex]}
          </span>
        </td>
        {uniqueDates.map((date, dateIndex) => (
          <td key={dateIndex}>{getDataForDateAndId(date, id)}</td>
        ))}
      </tr>
    ));
  };

  const getStatusColor = (status: string) => {
    return status === "PROCESSADO" ? "text-blue" : "text-red";

    //return status === "PENDENTE" ? "text-red" : "text-blue";
  };

  //console.log("getStatusColor :", getStatusColor);
  //console.log("statusLogs :", statusLogs);

  return (
    <>
      <Pagination3 page={page} onPageChange={changePage} />
      <div className="table-responsive" style={{ overflowX: "auto" }}>
        <table
          className="table table-striped table-sm"
          style={{ tableLayout: "auto" }}
        >
          <thead>
            <tr>
              <th>id_estrutura</th>
              <th>sigla</th>
              <th>nm_estrutura</th>
              <th>status_hoje</th>
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
