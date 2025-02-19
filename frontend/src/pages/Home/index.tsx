import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";
import { Link } from "react-router-dom";

// PROJETO DEVSUPERIOR - DSVENDAS E DSFILMES VERSAO FINAL ACESSO PRD EM CLOUD BB E FRONT ENDE.OK
// versao 20220626- funcionando, falta ajustar formulario de score de pontos de filmes -v001
const Home = () => {
  return (
    <>
      <NavBar1 />

      <div className="container">
        <div className="jumbotron">
          <h1 className="display-4">DSVendasXX</h1>
          <p className="lead">
            Analise o desempenho das suas vendas por diferentes perspectivas
          </p>
          <hr />
          <p>
            Esta aplicação consiste em exibir um dashboard a partir de dados
            fornecidos por um back end construído com Spring Boot.
          </p>

          <div className="col"></div>
          <Link className="btn btn-primary btn-lg" to="/dashboard">
            Acessar o Dashboard
          </Link>
          <div className="relative">
            <Link className="btn btn-primary btn-lg" to="/pagina09">
              Acessar Rel. ProcsPag
            </Link>
          </div>

          {/* <Link className="btn btn-primary btn-lg " to="/pagina07">
            Listagem de Filmes.
          </Link> */}
        </div>
        <hr />
        <Link className="btn btn-primary btn-lg" to="/cadvendedor">
          Cadastro - Vendedor
        </Link>
        <div className="relative">
          <Link className="btn btn-primary btn-lg" to="/pagina10">
            Acessar Rel. ProcsPag10
          </Link>
        </div>

        {/* <Link className="btn btn-primary btn-lg" to="/pagina05">
          exemplo List Box
        </Link> */}

        <hr />
        <Link className="btn btn-primary btn-lg" to="/cadvendas">
          Cadastro de Vendas
        </Link>
        <div className="relative">
          <Link className="btn btn-primary btn-lg" to="/pagina11">
            Acessar Rel. ProcsPag11
          </Link>
        </div>

        {/* <Link className="btn btn-primary btn-lg" to="/cadvendas2">
          Exemplo Labels e List
        </Link> */}

        <hr />
        <Link className="btn btn-primary btn-lg" to="/listVendedor">
          Acessar Rl Vendedor
        </Link>
        <div className="relative">
          <Link className="btn btn-primary btn-lg" to="/pagina12">
            Acessar  Movto Idtrutura
          </Link>
        </div>
        <hr />

        <Link className="btn btn-primary btn-lg" to="/listVendas">
          Acessar Rel. Vendas1
        </Link>
        <div className="relative">
          <Link className="btn btn-primary btn-lg" to="/pagina13">
            Acessar Movto de 7 dias
          </Link>
        </div>
        <hr />
        

        <Link className="btn btn-primary btn-lg" to="/pagina06">
          Acessar Rel. Vendas2
        </Link>
        <div className="relative">
          <Link className="btn btn-primary btn-lg" to="/cadestruturas">
            Cadastro de Estruturas.
          </Link>
        </div>

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

        <hr />
        <Link className="btn btn-primary btn-lg" to="/pagina08">
          Acessar Rel. Processo
        </Link>

        <hr />
      </div>

      <Footer />
    </>
  );
};

export default Home;
