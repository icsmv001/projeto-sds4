import axios from "axios";
import Pagination from "components/Pagination";

import React, { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";

import { BASE_URL } from "utils/requests";

const DataTableSale = () => {
  const [activePage, setActivePage] = useState(0);

  const [page, setpage] = useState<SalePage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  // chamada da api
  useEffect(() => {
    //axios.get("http://localhost:8080/sales?page=0&size=10&sort=date,desc")

    axios
      .get(`${BASE_URL}/sales?page=${activePage}&size=10&sort=id`)
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
      <Pagination page={page} onPageChange={changePage} />
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>Date</th>
              <th>Seller/Vendedor</th>
              <th>Visitas</th>
              <th>Fechadas</th>
              <th>Valor Vendas</th>
            </tr>
          </thead>
          <tbody>
            {page.content?.map((item) => (
              <tr key={item.id}>
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

export default DataTableSale;
