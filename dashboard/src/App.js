import React, {useState,useEffect} from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { fab } from "@fortawesome/free-brands-svg-icons";
import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useParams
} from "react-router-dom";
import PieCharts from './components/PieCharts/PieCharts';
import BarCharts from './components/BarCharts/BarCharts';
import Navigation from './components/Navigation/Navigation';
import Breadcrumbs from './components/Breadcrumbs/Breadcrumbs';
import LargeTitle from './components/LargeTitle/LargeTitle';
import Texts from './components/Texts/Texts';
import MetricsAll from './components/MetricsAll/MetricsAll';
import Summary from './components/Summary/Summary';
import ClassMetrics from './components/ClassMetrics/ClassMetrics';

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      metricsData: {summary: {}, classes: []}
    }
  }

  componentDidMount() {
    fetch(`${process.env.PUBLIC_URL}/results.json`)
      .then((r) => r.json())
      .then((data) => {
        console.log(data);
        this.setState({'metricsData': data});
        console.log('state:', this.state.metricsData);
      });
  }

  render(){
    return (
      <Router>
      <Navigation/>
      <Switch>
        <Route exact path="/">
          <div className="container">
            <div className="row">
              <div className="col-md-6 col-sm-12">
               <div className="card">
                <div className="card-body">
                  <PieCharts/>
                </div>
              </div>  
            </div>
            <div className="col-md-6 col-sm-12">
              <div className="card">
                <div className="card-body">
                  <BarCharts/>
                </div>
              </div>
              </div>
            </div>
          </div>
        </Route>
        <Route path="/dashboard">
          <div className="container-fluid">
            <div className="row">
              <div className="left-menu col-md-3 col-xl-3 col-sm-12 col-xs-12 bd-sidebar d-none d-sm-none d-md-block d-lg-block d-xl-block">
                <MetricsAll metricsData={this.state.metricsData}/>
              </div>
              <div className="metrics-summary col-xl-9 col-md-9 col-sm-12 col-xs-12">
                <Breadcrumbs />
                <LargeTitle name="Metrics Summary"/>
                <Texts text="Metrics Summary for store application"/>
                <div className="row">
                    <Summary metricsData={this.state.metricsData} />
                  </div>
              </div>
            </div>
          </div>
        </Route>
        <Route path="/metrics/classes/:id" render={({match}) => (
          <ClassMetrics classMetrics={this.state.metricsData.classes[match.params.id]} />
        )}>
        </Route>
      </Switch>
      </Router>
  );
  }


}

export default App;
