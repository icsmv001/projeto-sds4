import axios from "axios";
import React, { useEffect, useState } from "react";
import { BASE_URL } from "utils/requests";

import PaginationSeller from "components/PaginationSeller";
import { SellerPage } from "types/seller";
import NavBar from "components/Navbar";

const ListaVendedor = () => {
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
    axios
      .get(`${BASE_URL}/sellers?page=${activePage}&size=5,sort=id`)
      .then((response) => {
        try {
          console.log(response.data);
          setpage(response.data);
        } catch (e) {
          console.log(e);
        }
      });
  }, [activePage]);

  // funcao que recebe os argumentos de paginacao
  const changePage = (index: number) => {
    setActivePage(index);
  };

  return (
    <>
      <NavBar />
      <div className="container formVendas">
        <div className="jumbotron">
          <h1 className="display-4">Relatorio Cadastro de Vendedores</h1>
          <PaginationSeller page={page} onPageChange={changePage} />
          <div className="table-responsive">
            <table className="table table-striped table-sm">
              <thead>
                <tr>
                  <th>item</th>
                  <th>Vendedor</th>
                </tr>
              </thead>
              <tbody>
                {page.content?.map((item) => (
                  <tr key={item.id}>
                    <td>{item.id}</td>
                    <td>{item.name}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
};
export default ListaVendedor;
