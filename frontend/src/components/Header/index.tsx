import logo from '../../assets/img/logo.svg';
import './styles.css';

function Header(){
    return (
        <header>
        <div className="dsmeta-logo-container">
            <img src={logo} alt="DSMeta" />
            <h1>DSMeta</h1>
            <p>
              Desenvolvido por
              <a href="https://github.com/Carlvshns">&nbsp;Carlvs</a>
              <a href="https://dsmeta-carlvs.herokuapp.com/swagger-ui.html">D O C S</a>
              <br/>
            </p>
        </div>
    </header>
    )
}

export default Header;