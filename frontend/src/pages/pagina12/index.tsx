import React from "react";
import { useHistory, useLocation } from "react-router-dom";
import DataTableProcessos12b from "components/DataTableProcessos12b";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";

// Função para calcular a data 90 dias atrás
const getDate90DaysAgo = () => {
  const today = new Date();
  today.setDate(today.getDate() - 90);
  const day = String(today.getDate()).padStart(2, "0");
  const month = String(today.getMonth() + 1).padStart(2, "0");
  const year = today.getFullYear();
  return `${day}/${month}/${year}`;
};

const Pagina12 = () => {
  const history = useHistory(); // Hook para navegação
  const location = useLocation(); // Hook para obter a localização da URL

  // Função para extrair o parâmetro "id" da query string
  const queryParams = new URLSearchParams(location.search);
  const id_estrutura = queryParams.get("id") || "3221"; // Pega o valor do id ou usa o padrão

  const data = getDate90DaysAgo();
  //const id_estrutura = "3221"; // Exemplo de id_estrutura

  // Função para lidar com o clique
  const handleClick = () => {
    history.push("/pagina13"); // Redireciona para a página 13
  };

  return (
    <>
      <NavBar1 />
      <div className="container">
        <h2 className="text-primary py-3">
          Rel. Logs Processamentos - Estruturas - ICSMV001 - v.01-12b
        </h2>
        <h6
          onClick={handleClick}
          style={{
            cursor: "pointer",
            color: "blue",
            textDecoration: "underline",
          }}
        >
          Retorna ao Semanal
        </h6>

        {/* Passando os parâmetros para o DataTableProcessos12b */}
        <DataTableProcessos12b id_estrutura={id_estrutura} data={data} />
        {/* Adicionando o evento de clique */}
      </div>
      <Footer />
    </>
  );
};

export default Pagina12;
