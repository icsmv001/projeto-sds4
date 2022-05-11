// PROJETO DEVSUPERIOR - DSVENDAS E DSFILMES VERSAO FINAL ACESSO PRD EM CLOUD BB E FRONT ENDE.OK
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import { Link } from "react-router-dom";
const Home = () => {
  return (
    <>
      <NavBar1 />

      <div className="container">
        <div className="jumbotron">
          <h1 className="display-4">DSVendas</h1>
          <p className="lead">
            Analise o desempenho das suas vendas por diferentes perspectivas
          </p>
          <hr />
          <p>
            Esta aplicação consiste em exibir um dashboard a partir de dados
            fornecidos por um back end construído com Spring Boot.
          </p>

          <div className="row"></div>
          <Link className="btn btn-primary btn-lg" to="/dashboard">
            Acessar o Dashboard
          </Link>

          {/* <Link className="btn btn-primary btn-lg " to="/pagina07">
            Listagem de Filmes.
          </Link> */}
        </div>
        <hr />
        <Link className="btn btn-primary btn-lg" to="/cadvendedor">
          Cadastro - Vendedor
        </Link>

        {/* <Link className="btn btn-primary btn-lg" to="/pagina05">
          exemplo List Box
        </Link> */}

        <hr />
        <Link className="btn btn-primary btn-lg" to="/cadvendas">
          Cadastro de Vendas
        </Link>

        {/* <Link className="btn btn-primary btn-lg" to="/cadvendas2">
          Exemplo Labels e List
        </Link> */}

        <hr />
        <Link className="btn btn-primary btn-lg" to="/listVendedor">
          Acessar Rl Vendedor
        </Link>
        <hr />

        <Link className="btn btn-primary btn-lg" to="/listVendas">
          Acessar Rel. Vendas1
        </Link>
        <hr />

        <Link className="btn btn-primary btn-lg" to="/pagina06">
          Acessar Rel. Vendas2
        </Link>

        <hr />
        {/* 
        <Link className="btn btn-primary btn-lg" to="/cadvendas2">
          Exemplo Labels e List
        </Link> */}

        {/* <Link className="btn btn-primary btn-lg" to="/pagina05">
          exemplo List Box
        </Link> */}

        <Link className="btn btn-primary btn-lg " to="/pagina07">
          Acessar Listar Filmes
        </Link>
      </div>

      <Footer />
    </>
  );
};

export default Home;
