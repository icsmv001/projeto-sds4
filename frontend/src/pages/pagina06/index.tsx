import ListarVenda from "components/ListarVenda";
import Footer from "components/Footer";
import NavBar from "components/navbar";
import React from "react";

const Pagina06 = () => {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary py-3">Lista de Vendas - ICSMV001</h1>
        <h4>Sem Paginação </h4>

        <ListarVenda />
      </div>
      <Footer />
    </>
  );
};

export default Pagina06;
