import ListarProcessos from "components/ListarProcessos";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import React from "react";

const Pagina08 = () => {
  return (
    <>
      <NavBar1 />
      <div className="container">
        <h1 className="text-primary py-3">
          Rel. Logs Processamentos - ICSMV001 - v.01
        </h1>
        <h6>Sem Paginação </h6>

        <ListarProcessos />
      </div>
      <Footer />
    </>
  );
};

export default Pagina08;
