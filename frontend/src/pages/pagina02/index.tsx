import DataTableSale from "components/DataTableSale";

import Footer from "components/Footer";
//import NavBar from "components/Navbar";
import NavBar1 from "components/Navbar1";

import React from "react";

const Pagina02 = () => {
  return (
    <>
      <NavBar1 />
      <div className="container">
        <h1 className="text-primary py-3">Lista de Vendas - ICSMV001</h1>

        <DataTableSale />
      </div>
      <Footer />
    </>
  );
};

export default Pagina02;
