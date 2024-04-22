import DataTableProcessos13 from "components/DataTableProcessos13";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import React from "react";

const Pagina13 = () => {
  return (
    <>
      <NavBar1 />
      <div className="container">
        <h1 className="text-primary py-3">
          Rel. Logs Processamentos - Estruturas - ICSMV001 - v.01-13
        </h1>
        <h6>Com Paginação </h6>
        <DataTableProcessos13 />
      </div>
      <Footer />
    </>
  );
};

export default Pagina13;
