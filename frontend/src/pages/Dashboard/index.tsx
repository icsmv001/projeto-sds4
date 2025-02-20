import React from "react";
import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
//import DonutChart from "components/DonutChart";
import Footer from "components/Footer";
import NavBar1 from "components/Navbar1";

const Dashboard = () => {
  return (
    <>
      <NavBar1 />
      <div className="container">
        <h1 className="text-primary py-3">
          DashBord de Processamentos ultimos 7 dias - ICSMV001
        </h1>

        <div className="row px-3">
          <div className="col-sm-6">
            <h5 className="text-center text-secundary">Taxa de Sucesso (%)</h5>
            <BarChart />
          </div>

          {/* <div className="col-sm-6">
            <h5 className="text-center text-secundary">Total Recusas</h5>
            <DonutChart />
          </div>
         */}
        </div>

        <div className="py-3">
          <h2 className="text-primary"> Todas Vendas</h2>
        </div>
        <DataTable />
      </div>
      <Footer />
    </>
  );
};

export default Dashboard;
