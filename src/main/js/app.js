const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {equipmentSets: []}
    }

    componentDidMount() {
        client({method: 'GET', path: '/sets'})
            .done(response => {
                this.setState({equipmentSets: response.entity.equipmentSets})
            })
    }

    render() {
        return (
            <EquipmentSetList sets={this.state.equipmentSets}/>
        )
    }
}

class EquipmentSetList extends React.Component {
    render() {
        return (
            <ul>
                {this.props.sets.map(set => (<EquipmentSet set={set}/>))}
            </ul>
        )
    }
}

class EquipmentSet extends React.Component {
    render() {
        return (
            <li>{this.props.set}</li>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('react')
);