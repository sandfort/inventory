const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            equipmentPieces: [],
            equipmentSets: []
        }
    }

    componentDidMount() {
        client({method: 'GET', path: '/equips'})
            .done(response => {
                this.setState({equipmentPieces: response.entity.equipmentPieces})
            });

        client({method: 'GET', path: '/sets'})
            .done(response => {
                this.setState({equipmentSets: response.entity.equipmentSets})
            })
    }

    render() {
        return (
            <div>
                <EquipmentPieceList equips={this.state.equipmentPieces}/>
                <EquipmentSetList sets={this.state.equipmentSets}/>
            </div>
        )
    }
}

class EquipmentSetList extends React.Component {
    render() {
        return (
            <div>
                <h1>Equipment Sets</h1>

                <div>
                    {this.props.sets.map(set => (<EquipmentSet key={set.id} set={set}/>))}
                </div>
            </div>
        )
    }
}

class EquipmentSet extends React.Component {
    render() {
        return (
            <div>
                <table>
                    <thead>
                    <tr>
                        <th>Slot</th>
                        <th>Name</th>
                        <th>Skill Modifiers</th>
                    </tr>
                    </thead>
                    <tbody>
                    <EquipmentPieceRow slot="head" equip={this.props.set.head}/>
                    <EquipmentPieceRow slot="chest" equip={this.props.set.chest}/>
                    <EquipmentPieceRow slot="arms" equip={this.props.set.arms}/>
                    <EquipmentPieceRow slot="waist" equip={this.props.set.waist}/>
                    <EquipmentPieceRow slot="legs" equip={this.props.set.legs}/>
                    <EquipmentPieceRow slot="talisman" equip={this.props.set.talisman}/>
                    </tbody>
                </table>
            </div>
        )
    }
}

class EquipmentPieceForm extends React.Component {
    render() {
        return (
            <form>
                <label>
                    Name
                    <input type="text" name="name"/>
                </label>
            </form>
        )
    }
}

class EquipmentPieceRow extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.slot}</td>
                <td>{this.props.equip.name}</td>
                <td>n/a</td>
            </tr>
        )
    }
}

class EquipmentPieceList extends React.Component {
    render() {
        return (
            <div>
                <h1>Equipment Pieces</h1>
                <ul>
                    {this.props.equips.map((equip) => <EquipmentPiece key={equip.name} equip={equip}/>)}
                </ul>
            </div>
        )
    }
}

class EquipmentPiece extends React.Component {
    render() {
        return (
            <li>{this.props.equip.name}</li>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('react')
);