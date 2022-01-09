import DataTableSale from "components/DataTableSale";

import Footer from "components/Footer";
import NavBar from "components/navbar";
import React from "react";

const Pagina01 = () => {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary py-3">Lista de Vendas - ICSMV001</h1>

        <DataTableSale />
      </div>
      <Footer />
    </>
  );
};

export default Pagina01;
