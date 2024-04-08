import DataTableProcessos from "components/DataTableProcessos";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import React from "react";

const Pagina09 = () => {
  return (
    <>
      <NavBar1 />
      <div className="container">
        <h1 className="text-primary py-3">
          Rel. Logs Processamentos - ICSMV001 - v.01-pg9
        </h1>
        <h6>Com Paginação </h6>
        - <DataTableProcessos />
      </div>
      <Footer />
    </>
  );
};

export default Pagina09;
