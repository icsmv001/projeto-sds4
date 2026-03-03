// versao 2022/06/26 - funcionando
// PROJETO DEVSUPERIOR - DSVENDAS E DSFILMES
// Ajustado para React Router v5.3.0 - compatível com Node 22

import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

import Dashboard from "pages/Dashboard";
import Home from "pages/Home";
import Pagina01 from "pages/pagina01";
import Pagina02 from "pages/pagina02";
import Pagina03 from "pages/pagina03";
import Pagina04 from "pages/pagina04";
import Pagina05 from "pages/pagina05";
import Pagina06 from "pages/pagina06";
import Pagina07 from "pages/pagina07";
import Pagina08 from "pages/pagina08";
import Pagina09 from "pages/pagina09";
import Pagina10 from "pages/pagina10";
import Pagina11 from "pages/pagina11";
import Pagina12 from "pages/pagina12";
import Pagina13 from "pages/pagina13";
import Pagina14 from "pages/pagina14";
import Cadvendas2 from "pages/Cadvendas2";
import FormCard from "pages/FormCard";

const Routes = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/dashboard" component={Dashboard} />
        <Route path="/listVendedor" component={Pagina01} />
        <Route path="/listVendas" component={Pagina02} />
        <Route path="/cadvendedor" component={Pagina03} />
        <Route path="/cadvendas" component={Pagina04} />
        <Route path="/cadvendas2" component={Cadvendas2} />
        <Route path="/pagina05" component={Pagina05} />
        <Route path="/pagina06" component={Pagina06} />
        <Route path="/pagina07" component={Pagina07} />
        <Route path="/FormCard/:idParam" component={FormCard} />
        <Route path="/pagina08" component={Pagina08} />
        <Route path="/pagina09" component={Pagina09} />
        <Route path="/pagina10" component={Pagina10} />
        <Route path="/pagina11" component={Pagina11} />
        <Route path="/pagina12" component={Pagina12} />
        <Route path="/pagina13" component={Pagina13} />
        <Route path="/cadestruturas" component={Pagina14} />
      </Switch>
    </BrowserRouter>
  );
};

export default Routes;