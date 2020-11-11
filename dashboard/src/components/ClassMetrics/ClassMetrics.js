import React, { Component } from 'react';
import MetricsAll from '../MetricsAll/MetricsAll';
import MobileMetricsMenu from '../MobileMetricsMenu/MobileMetricsMenu';
import Breadcrumbs from '../Breadcrumbs/Breadcrumbs';
import LargeTitle from '../LargeTitle/LargeTitle';
import Texts from '../Texts/Texts';
import Summary from '../Summary/Summary';


class ClassMetrics extends Component {
    render() {
        if (this.props.classMetrics) {
            return (
                <div>  
                   <div className="container-fluid">
               <div className="row">
                  <div className="left-menu col-md-3 col-xl-3 col-sm-12 col-xs-12 bd-sidebar2 d-none d-sm-none d-md-block d-lg-block d-xl-block">
                    <MetricsAll metricsData={this.props.metricsData}/>
                  </div>
                  <div className="col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none">
                    <MobileMetricsMenu metricsData={this.props.metricsData} />
                  </div>
                  <div className="metrics-summary col-xl-9 col-md-9 col-sm-12 col-xs-12">
                   <LargeTitle name={this.props.classMetrics.className}/>
                    <h3>Ancestors:</h3>
                    <ol>
                        {this.props.classMetrics.dit.ancestors.map(((v, i) => {
                            return (<li key={i}>{ v.toString() }</li> )
                        }))}
                    </ol>
                  </div>
               </div>
            </div>
                </div>
            )
        } else {
            return (
                <div>
                    No Class Found... 
                </div>
            )
        }
    }
}

export default ClassMetrics;