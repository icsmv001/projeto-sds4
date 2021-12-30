import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import Cadvendas from "pages/Cadvendas";
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

        <Route path="/cadvendas">
          <Cadvendas />
        </Route>
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;
