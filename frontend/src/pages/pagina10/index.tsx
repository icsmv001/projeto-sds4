import DataTableProcessos10 from "components/DataTableProcessos10";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import React from "react";

const Pagina10 = () => {
  return (
    <>
      <NavBar1 />
      <div className="container">
        <h1 className="text-primary py-3">
          Rel. Logs Processamentos - Estruturas - ICSMV001 - v.01-pg10
        </h1>
        <h6>Com Paginação </h6>
        <DataTableProcessos10 />
      </div>
      <Footer />
    </>
  );
};

export default Pagina10;
