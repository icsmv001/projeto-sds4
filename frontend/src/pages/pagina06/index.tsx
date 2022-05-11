import ListarVenda from "components/ListarVenda";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import React from "react";

const Pagina06 = () => {
  return (
    <>
      <NavBar1 />
      <div className="container">
        <h1 className="text-primary py-3">Lista de Vendas - ICSMV001 - v.01</h1>
        <h4>Sem Paginação </h4>

        <ListarVenda />
      </div>
      <Footer />
    </>
  );
};

export default Pagina06;
