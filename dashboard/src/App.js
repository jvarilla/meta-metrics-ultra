import React from 'react';
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
import metricsData from './metricsData';
import Navigation from './components/Navigation/Navigation';

class App extends React.Component {
  render(){
    return (
      <Router>
      <Navigation/>
      <Switch>
        <Route exact path="/">
         <div class="container">
     <div class="row">
      <div class="col-md-6 col-sm-12">
          <div class="card">
              <div class="card-body">
                <PieCharts/>
              </div>
          </div>  
      </div>
      <div class="col-md-6 col-sm-12">
          <div class="card">
              <div class="card-body">
                <BarCharts/>
              </div>
          </div>
      </div>
     </div>
    </div>
   </Route>
         <Route path="/dashboard">
            <h3>Test json: {metricsData.summary.pathToSrc}</h3>
         </Route>
        // <Route path="/dashboard/:item">
           
        // </Route>
      </Switch>
      </Router>
  );
  }
}

export default App;
