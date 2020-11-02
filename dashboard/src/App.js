import React from 'react';
import './App.css';
import PieCharts from './components/PieCharts/PieCharts';
import BarCharts from './components/BarCharts/BarCharts';


class App extends React.Component {
  render(){
    return (
    <div class="container">
     <div class="row">
      <div class="col-md-6 col-sm-12">
        <PieCharts/>
      </div>
      <div class="col-md-6 col-sm-12">
        <BarCharts/>
      </div>
     </div>
    </div>
  );
  }
}

export default App;
