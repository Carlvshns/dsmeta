import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type Props = {
    saleId: number
}

function NotificationButton({saleId} : Props){

    const notifySubmit = (id : number) => {
        axios(`${BASE_URL}/api/v1/sales/${id}/notification}`)
        .then(response => {
            toast.info("Notificacao SMS enviada com sucesso");
        })
    }
    
    return(
        <div className="dsmeta-red-btn" onClick={ () => notifySubmit(saleId)}>
            <img src={icon} alt="Notificar"/>
        </div>
    )
}

export default NotificationButton;