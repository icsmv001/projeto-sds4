import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import Pagina01 from "pages/pagina01";
import Pagina02 from "pages/pagina02";

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

        {/* <Route path="/cadVendedor">
          <CadVendedor />
        </Route> */}

        {/* <Route path="/cadvendas">
          <Cadvendas />
        </Route> */}

        {/* <Route path="/listVendedor">
          <ListVendedor />
        </Route> */}

        <Route path="/listVendedor">
          <Pagina01 />
        </Route>

        <Route path="/listVendas">
          <Pagina02 />
        </Route>
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;
