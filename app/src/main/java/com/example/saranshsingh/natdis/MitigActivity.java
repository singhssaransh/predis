package com.example.saranshsingh.natdis;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class MitigActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitig);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
       // for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("Earthquake ","Long-term measures \n" +
                    "\uF0B7 Re-framing buildings codes, guidelines, manuals and byelaws and their strict\n" +
                    "implementation. Tougher legislation for highly seismic areas.\n" +
                    "\uF0B7 Incorporating earthquake resistant features in all buildings at high-risk areas.\n" +
                    "\uF0B7 Making all public utilities like water supply systems, communication\n" +
                    "networks, electricity lines etc. earthquake-proof. Creating alternative\n" +
                    "arrangements to reduce damages to infrastructure facilities.\n" +
                    "\uF0B7 Constructing earthquake-resistant community buildings and buildings (used\n" +
                    "to gather large groups during or after an earthquake) like schools,\n" +
                    "dharamshalas, hospitals, prayer halls, etc., especially in seismic zones of\n" +
                    "moderate to higher intensities.\n" +
                    "\uF0B7 Supporting R&D in various aspects of disaster mitigation, preparedness and\n" +
                    "prevention and post-disaster management.\n" +
                    "\uF0B7 Evolving educational curricula in architecture and engineering institutions\n" +
                    "and technical training in polytechnics and schools to include disaster related\n" +
                    "topics.\n" +
                    "Medium term measures\n" +
                    "\uF0B7 Retrofitting of weak structures in highly seismic zones.\n" +
                    "\uF0B7 Preparation of disaster related literature in local languages with dos and\n" +
                    "don'ts for construction.\n" +
                    "\uF0B7 Getting communities involved in the process of disaster mitigation through\n" +
                    "education and awareness.\n" +
                    "\uF0B7 Networking of local NGOs working in the area of disaster management.\n" +
                    "Post-Disaster Preventive Measures2\n" +
                    "\uF0B7 Maintenance of law and order, prevention of trespassing, looting etc.\n" +
                    "\uF0B7 Evacuation of people.\n" +
                    "\uF0B7 Recovery of dead bodies and their disposal.\n" +
                    "\uF0B7 Medical care for the injured.\n" +
                    "\uF0B7 Supply of food and drinking water.\n" +
                    "\uF0B7 Temporary shelters like tents, metal sheds etc.\n" +
                    "\uF0B7 Repairing lines of communication and information. \n" +
                    "\uF0B7 Restoring transport routes.\n" +
                    "\uF0B7 Quick assessment of destruction and demarcation of destroyed areas,\n" +
                    "according to the grade of damage.\n" +
                    "\uF0B7 Cordoning off severely damaged structures that are liable to collapse during\n" +
                    "aftershocks. ");
            results.add(0, obj);

        DataObject obj1 = new DataObject("Tsunami ","Important Facts to Know about Tsunamis\n" +
                "\n" +
                "Tsunamis that strike coastal locations in the Pacific Ocean Basin are most always caused by earthquakes. These earthquakes might occur far away or near where you live.\n" +
                "Some tsunamis can be very large. In coastal areas their height can be as great as 30 feet or more (100 feet in extreme cases), and they can move inland several hundred feet.\n" +
                "All low-lying coastal areas can be struck by tsunamis.\n" +
                "A tsunami consists of a series of waves. Often the first wave may not be the largest. The danger from a tsunami can last for several hours after the arrival of the first wave.\n" +
                "Tsunamis can move faster than a person can run.\n" +
                "Sometimes a tsunami causes the water near the shore to recede, exposing the ocean floor.\n" +
                "The force of some tsunamis is enormous. Large rocks weighing several tons along with boats and other debris can be moved inland hundreds of feet by tsunami wave activity. Homes and other buildings are destroyed. All this material and water move with great force and can kill or injure people.\n" +
                "Tsunamis can occur at any time, day or night.\n" +
                "Tsunamis can travel up rivers and streams that lead to the ocean.\n+" +
                "If you are on land:\n" +
                "\n" +
                "Be aware of tsunami facts. This knowledge could save your life! Share this knowledge with your relatives and friends. It could save their lives!\n" +
                "If you are in school and you hear there is a tsunami warning, you should follow the advice of teachers and other school personnel.\n" +
                "If you are at home and hear there is a tsunami warning, you should make sure your entire family is aware of the warning. Your family should evacuate your house if you live in a tsunami evacuation zone. Move in an orderly, calm and safe manner to the evacuation site or to any safe place outside your evacuation zone. Follow the advice of local emergency and law enforcement authorities.\n" +
                "If you are at the beach or near the ocean and you feel the earth shake, move immediately to higher ground, DO NOT wait for a tsunami warning to be announced. Stay away from rivers and streams that lead to the ocean as you would stay away from the beach and ocean if there is a tsunami. A regional tsunami from a local earthquake could strike some areas before a tsunami warning could be announced.\n" +
                "Tsunamis generated in distant locations will generally give people enough time to move to higher ground. For locally-generated tsunamis, where you might feel the ground shake, you may only have a few minutes to move to higher ground.\n" +
                "High, multi-story, reinforced concrete hotels are located in many low-lying coastal areas. The upper floors of these hotels can provide a safe place to find refuge should there be a tsunami warning and you cannot move quickly inland to higher ground. Local Civil Defense procedures may, however, not allow this type of evacuation in your area. Homes and small buildings located in low-lying coastal areas are not designed to withstand tsunami impacts. Do not stay in these structures should there be a tsunami warning.\n" +
                "Offshore reefs and shallow areas may help break the force of tsunami waves, but large and dangerous wave can still be a threat to coastal residents in these areas. Staying away from all low-lying areas is the safest advice when there is a tsunami warning.\n" +
                "If you are on a boat:\n" +
                "\n" +
                "Since tsunami wave activity is imperceptible in the open ocean, do not return to port if you are at sea and a tsunami warning has been issued for your area. Tsunamis can cause rapid changes in water level and unpredictable dangerous currents in harbors and ports.\n" +
                "If there is time to move your boat or ship from port to deep water (after a tsunami warning has been issued), you should weigh the following considerations:\n" +
                "\n" +
                "Most large harbors and ports are under the control of a harbor authority and/or a vessel traffic system. These authorities direct operations during periods of increased readiness (should a tsunami be expected), including the forced movement of vessels if deemed necessary. Keep in contact with the authorities should a forced movement of vessel be directed.\n" +
                "Smaller ports may not be under the control of a harbor authority. If you are aware there is a tsunami warning and you have time to move your vessel to deep water, then you may want to do so in an orderly manner, in consideration of other vessels. Owners of small boats may find it safest to leave their boat at the pier and physically move to higher ground, particularly in the event of a locally-generated tsunami. Concurrent severe weather conditions (rough seas outside of safe harbor) could present a greater hazardous situation to small boats, so physically moving yourself to higher ground may be the only option.\n" +
                "Damaging wave activity and unpredictable currents can effect harbors for a period of time following the initial tsunami impact on the coast. Contact the harbor authority before returning to port making sure to verify that conditions in the harbor are safe for navigation and berthing.");
        results.add(1, obj1);

        DataObject obj2 = new DataObject("Cyclone/Hurricane ","•\tHelipads should be constructed at regular intervals through highways and roads built in BOT mode\n" +
                "\n" +
                "•\tHelipads should be along highways; sites for air landing should also be available for vulnerable locations such as schools, playgrounds and so on \n" +
                "\n" +
                "•\tSupport should be provided to amateur radio volunteers at normal times so that they can effectively handle the cyclone \n" +
                "\n" +
                "•\tMaintenance of embankments should be crafted with fine workmanship to mitigate flooding risk during cyclones \n" +
                "\n" +
                "•\tIncentivising measure should be there to reward states for disaster preparedness \n" +
                "\n" +
                "•\tCall for zero casualty should not encourage suppression of data \n" +
                "\n" +
                "•\tLong term mitigation measures should also be in place in district plans \n" +
                "•\tIn coastal towns and cities, building rules need to be revisited and structural safety is a must; cyclone resilient structures must be constructed\n" +
                "\n" +
                "•\tInfrastructure in vulnerable areas such as roads, public buildings, bridges, communication systems and key infrastructure such as airports and hospitals must be resilient to cyclones \n" +
                "\n" +
                "•\tAgeing test and assessment of retrofitting requirements should be mandatory for major city buildings beyond 15 to 20 years old \n" +
                "\n" +
                "•\tCoastal Regulation Zone norms should be strictly enforced \n" +
                "\n" +
                "•\tCoastal Zone Regulatory Authority should be created under central auspices with state counterpart organisations covering the entire coastline of the country for management of marine resources and reserve forests \n" +
                "\n" +
                "•\tPlanning as well as balancing of the coastal vegetation and green cover should be taken up\n" +
                "\n" +
                "•\tSuitable guidelines should be framed by states for construction of hoardings \n" +
                "\n" +
                "•\tEvacuation routes in disaster management plans should be delineated prior to onset of monsoons \n" +
                "\n" +
                "•\tTelecom systems need to be robust wherein coastal mobile towers must be able to bear winds at speeds of 250 km/hr\n" +
                "\n" +
                "•\tAlternative channels of communications should be set up including VF/HUF sets, satellite phones, radio, community radio, internet and loud speakers for communication during the crisis\n" +
                "\n" +
                "•\tUnderground power cable and utility lines should also be planned in a manner that they are functional and financially viable \n" +
                "\n" +
                "•\tLast mile connectivity must be ensured\n" +
                "\n" +
                "•\tComprehensive state insurance cover needs to be provided for persons, their properties and cattle \n" +
                "\n" +
                "Facts and Stats\n" +
                "\n" +
                "•\tEarly warning systems such as IMD, CWC, INCOIS are there for disaster management in the event of cyclones\n" +
                "\n" +
                "•\tAdvisory service providers during cyclones include:\n" +
                "-\tAgromet Advisory Service(IMD)\n" +
                "-\tPotential Fishing Zone Advisory Services(INCOIS)\n" +
                "-\tAgriculture advisory service (Department of Agriculture)\n" +
                "\n" +
                "•\tOther stakeholders in effective cyclone management include the following:\n" +
                "-\tRoad, rail and civil aviation authorities\n" +
                "-\tDisaster Management Agencies\n" +
                "-\tDefence, police, power, telecom, health, water and sanitation \n" +
                "-\tEducational authorities\n" +
                "-\tPrint and Electronic Media \n" +
                "-\tNGOs\n" +
                "-\tOrganisations of public and private sector across coastline\n" +
                "-\tCitizens");
        results.add(2, obj2);
        return results;
    }
}