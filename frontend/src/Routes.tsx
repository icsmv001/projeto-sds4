// versao 2022/06/26 - funcionando
// PROJETO DEVSUPERIOR - DSVENDAS E DSFILMES VERSAO FINAL ACESSO PRD EM CLOUD BB E FRONT ENDE.OK
// versao 20220626- funcionando, falta ajustar formulario de score de pontos de filmes -v001
import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import Pagina01 from "pages/pagina01";
import Pagina02 from "pages/pagina02";
import Pagina03 from "pages/pagina03";
import Pagina04 from "pages/pagina04";
import Pagina05 from "pages/pagina05";
import Pagina06 from "pages/pagina06";
import Pagina07 from "pages/pagina07";
import Cadvendas2 from "pages/Cadvendas2";
import Form from "pages/Form";
//import Listing from "pages/Listing";

// import CadVendedor from "components/CadVendedor";
// import Cadvendas from "pages/Cadvendas";
import React, { Route, Switch } from "react-router";
import { BrowserRouter } from "react-router-dom";

const Routes = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route path="/dashboard">
          <Dashboard />
        </Route>
        <Route path="/listVendedor">
          <Pagina01 />
        </Route>
        <Route path="/listVendas">
          <Pagina02 />
        </Route>
        <Route path="/cadvendedor">
          <Pagina03 />
        </Route>
        <Route path="/cadvendas">
          <Pagina04 />
        </Route>
        <Route path="/cadvendas2">
          <Cadvendas2 />
        </Route>

        <Route path="/pagina05">
          <Pagina05 />
        </Route>

        <Route path="/pagina06">
          <Pagina06 />
        </Route>

        <Route path="/pagina07">
          <Pagina07 />
        </Route>

        <Route path="/form">
          <Form />
        </Route>

        {/* <Route path="/listing">
          <Listing />
        </Route> */}
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;
