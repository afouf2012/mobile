/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entitie.Club;
import com.mycompany.myapp.gui.services.ClubService;
import java.util.ArrayList;

/**
 *
 * @author Ahmed laifi
 */
public class afficheClubClient extends Form{
    Form current;
   
        static Club b=new Club();

             
             ArrayList<Club> list2=new ArrayList<>();

   public afficheClubClient(Form previous) {
      current=this;
      Style eventStyle= getAllStyles();
        eventStyle.setBgColor(0xCD853F);
        setTitle("Club");
        setLayout(BoxLayout.y());
       
         getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new menuClub().show();});
        
/***********************************************************************************/
         
         
         
         ArrayList<Club> liste=ClubService.getInstance().getAllclub();

  
         
   Container listss = new Container(BoxLayout.y());
        Container lists = new Container(BoxLayout.y());
        
        
      for(Club c1 : liste) {
            listss.add(createCoursContainer(c1));
        }
           
           
           
      /*************************/
            Style st=lists.getAllStyles();
        st.setMargin(Component.BOTTOM,900);
        Tabs t = new Tabs();
    
         t.setUIID("Tab");        
        t.addTab("ma liste", listss);
        t.setScrollableY(true);
         add(t);

        }
   private Container createCoursContainer(Club clubes) {
             
            Button bt1=new Button("s'insrire");
            Style butStylebn=bt1.getAllStyles();
    
butStylebn.setFgColor(0x000000);
              

          
               Label titre1 = new Label("nom");
            Label description1 = new Label("fodateur");
            Label datedebut1 = new Label("date creation");


            Label titre = new Label("");
            Label description = new Label("");
            Label datedebut = new Label("");
     

           

            Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           cnt.getStyle().setBgColor(0xFFFFFF);
        cnt.getStyle().setBgTransparency(255);
        titre.getAllStyles().setFgColor(0x000000);
        description.getAllStyles().setFgColor(0x000000);
        datedebut.getAllStyles().setFgColor(0x000000);
     
            cnt.add(titre1);
            cnt.add(titre);
            cnt.add(description1);
            cnt.add(description);
            cnt.add(datedebut1);
            cnt.add(datedebut);


        Style st=cnt.getAllStyles();
        st.setMargin(Component.BOTTOM,2);


            titre.setText(clubes.getNom());
            description.setText(clubes.getFondateur());
           datedebut.setText(clubes.getDate_creation());
     
       
    

           Container c4=BoxLayout.encloseX(bt1);
            bt1.addActionListener(e->{ 
                list2=ClubService.getInstance().rembourser(clubes.getId());
                  list2=ClubService.getInstance().getAllclub();
                    Dialog.show("Frais d'inscription 10 DT", "Voulez-vous s'inscrire a cette club ?", new Command("OK"));

             
    });
   
          
 
                   return BorderLayout.center(cnt).
                add(BorderLayout.EAST,c4);
        }

       
   
        

    
}
