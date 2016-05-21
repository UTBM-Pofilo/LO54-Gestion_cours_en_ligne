/*
 * Copyright (C) 2016
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.utbm.lo54.project.core;

import fr.utbm.lo54.project.core.entity.Client;
import fr.utbm.lo54.project.core.service.ClientService;
import fr.utbm.lo54.project.core.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App0 {
    private final static Logger LOGGER = LoggerFactory
			.getLogger(App0.class);
    
    public static void main(String[] args) {
        
        Client client = new Client();
        client.setAddress("Lyon");
        client.setEmail("aamail");
        client.setFirstName("aa1stname");
        client.setLastName("aalastname");
        client.setPhone("aa06");
        //client.setCourseSessionId(0);
        
        ClientService clientService = new ClientService();
        HibernateUtil.getSession();
        //clientService.storeEntity(client);
        //Client client2 = (Client) clientService.getEntity(0);
        //LOGGER.info("----> " + client2.getPhone());
        //clientService.removeEntity(client2);
        
        //List<IEntity> listClient = clientService.getEntities();
        
        //for(IEntity entity : listClient) {
         //   Client client3 = (Client) entity;
            //LOGGER.info("************> " + client3.toString());
       // }
        
        LOGGER.info("\n\n\n\nOK");
    
    }
}
