import DataTableSellers from "components/DataTableSellers";
import Footer from "components/Footer";
import NavBar from "components/Navbar";
import React from "react";

const Pagina01 = () => {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary py-3">Lista de Vendedores - ICSMV001</h1>

        <DataTableSellers />
      </div>
      <Footer />
    </>
  );
};

export default Pagina01;
