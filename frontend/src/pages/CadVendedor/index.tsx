import axios from "axios";
import PaginationSeller from "components/PaginationSeller";
import React, { useEffect, useState } from "react";
import { SellerPage } from "types/seller";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";
import NavBar from "components/navbar";

const DataTableSellers = () => {
  const [activePage, setActivePage] = useState(0);

  const [page, setpage] = useState<SellerPage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  // chamada da api
  useEffect(() => {
    //axios.get("http://localhost:8080/sellers?page=0&size=10&sort=date,desc")

    axios
      .get(`${BASE_URL}/sellers?page=${activePage}&size=20&sort=date,desc`)
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
      <NavBar />


    
      <PaginationSeller page={page} onPageChange={changePage} />
      <div className="table-responsive">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              <th>id</th>
              <th>Vendedor</th>
              
            </tr>
          </thead>
          <tbody>
            {page.content?.map((item) => (
              <tr key={item.id}>
                <td>{item.name}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default DataTableSellers;
