Function inititemtemplates%()
    Local local0.itemtemplates
    Local local1.itemtemplates
    local0 = createitemtemplate("Some SCP-420-J", "scp420j", "GFX\items\scp_420_j.x", "GFX\items\INV_scp_420_j.png", "", 0.0005, "", "", $00, $09)
    local0\Field2 = $02
    createitemtemplate("Level 1 Key Card", "key1", scpmodding_processfilepath("GFX\items\key_card.x"), scpmodding_processfilepath("GFX\items\INV_key_card_lvl_1.png"), "", 0.0004, scpmodding_processfilepath("GFX\items\key_card_lvl_1.png"), "", $00, $09)
    createitemtemplate("Level 2 Key Card", "key2", scpmodding_processfilepath("GFX\items\key_card.x"), scpmodding_processfilepath("GFX\items\INV_key_card_lvl_2.png"), "", 0.0004, scpmodding_processfilepath("GFX\items\key_card_lvl_2.png"), "", $00, $09)
    createitemtemplate("Level 3 Key Card", "key3", scpmodding_processfilepath("GFX\items\key_card.x"), scpmodding_processfilepath("GFX\items\INV_key_card_lvl_3.png"), "", 0.0004, scpmodding_processfilepath("GFX\items\key_card_lvl_3.png"), "", $00, $09)
    createitemtemplate("Level 4 Key Card", "key4", scpmodding_processfilepath("GFX\items\key_card.x"), scpmodding_processfilepath("GFX\items\INV_key_card_lvl_4.png"), "", 0.0004, scpmodding_processfilepath("GFX\items\key_card_lvl_4.png"), "", $00, $09)
    createitemtemplate("Level 5 Key Card", "key5", scpmodding_processfilepath("GFX\items\key_card.x"), scpmodding_processfilepath("GFX\items\INV_key_card_lvl_5.png"), "", 0.0004, scpmodding_processfilepath("GFX\items\key_card_lvl_5.png"), "", $00, $09)
    createitemtemplate("Playing Card", "misc", scpmodding_processfilepath("GFX\items\key_card.x"), scpmodding_processfilepath("GFX\items\INV_playing_card.png"), "", 0.0004, scpmodding_processfilepath("GFX\items\playing_card.png"), "", $00, $09)
    createitemtemplate("Mastercard", "misc", scpmodding_processfilepath("GFX\items\key_card.x"), scpmodding_processfilepath("GFX\items\INV_master_card.png"), "", 0.0004, scpmodding_processfilepath("GFX\items\master_card.png"), "", $00, $09)
    createitemtemplate("Key Card Omni", "key7", scpmodding_processfilepath("GFX\items\key_card.x"), scpmodding_processfilepath("GFX\items\INV_key_card_lvl_omni.png"), "", 0.0004, scpmodding_processfilepath("GFX\items\key_card_lvl_omni.png"), "", $00, $09)
    local0 = createitemtemplate("SCP-860", "scp860", scpmodding_processfilepath("GFX\items\scp_860.b3d"), scpmodding_processfilepath("GFX\items\INV_scp_860.png"), "", 0.0026, "", "", $00, $09)
    local0\Field2 = $03
    local0 = createitemtemplate("Document SCP-079", "paper", scpmodding_processfilepath("GFX\items\paper.x"), scpmodding_processfilepath("GFX\items\INV_paper.png"), scpmodding_processfilepath("GFX\items\doc_079.png"), 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-895", "paper", scpmodding_processfilepath("GFX\items\paper.x"), scpmodding_processfilepath("GFX\items\INV_paper.png"), scpmodding_processfilepath("GFX\items\doc_895.png"), 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-860", "paper", scpmodding_processfilepath("GFX\items\paper.x"), scpmodding_processfilepath("GFX\items\INV_paper.png"), scpmodding_processfilepath("GFX\items\doc_860.png"), 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-860-1", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_860_1.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("SCP-093 Recovered Materials", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_093_rm.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-106", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_106.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Dr. Allok's Note", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_106(2).png", (1.0 / 400.0), "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Recall Protocol RP-106-N", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_RP.png", (1.0 / 400.0), "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-682", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_682.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-173", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_173.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-372", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_372.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-049", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_049.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-096", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_096.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-008", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_008.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-012", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_012.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-500", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_500.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-714", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_714.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-513", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_513.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-035", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_035.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("SCP-035 Addendum", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_035_ad.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-939", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_939.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-966", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_966.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-970", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_970.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-1048", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_1048.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-1123", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_1123.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-1162", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_1162.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-1499", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_1499.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Incident Report SCP-1048-A", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_1048_a.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Drawing", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_1048.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Leaflet", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\leaflet.png", 0.003, "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Dr. L's Note", "paper", "GFX\items\paper.x", "GFX\items\INV_note.png", "GFX\items\doc_L.png", (1.0 / 400.0), "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Dr L's Note", "paper", "GFX\items\paper.x", "GFX\items\INV_note.png", "GFX\items\doc_L(2).png", (1.0 / 400.0), "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Blood-stained Note", "paper", "GFX\items\paper.x", "GFX\items\INV_note_bloody.png", "GFX\items\doc_L(3).png", (1.0 / 400.0), "GFX\items\note_bloody.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Dr. L's Burnt Note", "paper", "GFX\items\paper.x", "GFX\items\INV_burnt_note.png", "GFX\items\doc_L(4).png", (1.0 / 400.0), "GFX\items\burnt_note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Dr L's Burnt Note", "paper", "GFX\items\paper.x", "GFX\items\INV_burnt_note.png", "GFX\items\doc_L(5).png", (1.0 / 400.0), "GFX\items\burnt_note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Scorched Note", "paper", "GFX\items\paper.x", "GFX\items\INV_burnt_note.png", "GFX\items\doc_L(6).png", (1.0 / 400.0), "GFX\items\burnt_note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Journal Page", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_Gonzales.png", (1.0 / 400.0), "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Log #1", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\f(4).png", 0.004, "GFX\items\f(4).png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Log #2", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\f(5).png", 0.004, "GFX\items\f(4).png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Log #3", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\f(6).png", 0.004, "GFX\items\f(4).png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Strange Note", "paper", "GFX\items\paper.x", "GFX\items\INV_note.png", "GFX\items\doc_Strange.png", (1.0 / 400.0), "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Nuclear Device Document", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_NDP.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Class D Orientation Leaflet", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_ORI.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Note from Daniel", "paper", "GFX\items\note.x", "GFX\items\INV_note(2).png", "GFX\items\doc_dan.png", (1.0 / 400.0), "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Burnt Note", "paper", "GFX\items\paper.x", "GFX\items\INV_burnt_note.png", "GFX\items\bn.it", 0.003, "GFX\items\burnt_note.png", "", $00, $09)
    local0\Field11 = burntnote
    local0\Field2 = $00
    local0 = createitemtemplate("Mysterious Note", "paper", "GFX\items\paper.x", "GFX\items\INV_note.png", "GFX\items\sn.it", 0.003, "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Mobile Task Forces", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_MTF.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Security Clearance Levels", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_SC.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Object Classes", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_OBJC.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_RAND(3).png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Addendum: 5/14 Test Log", "paper", "GFX\items\paper.x", "GFX\items\INV_note.png", "GFX\items\doc_RAND(2).png", 0.003, "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Notification", "paper", "GFX\items\paper.x", "GFX\items\INV_note.png", "GFX\items\doc_RAND.png", 0.003, "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Incident Report SCP-106-0204", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_IR_106.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Ballistic Vest", "vest", "GFX\items\vest.x", "GFX\items\INV_vest.png", "", 0.02, "GFX\items\vest.png", "", $00, $09)
    local0\Field2 = $04
    local0 = createitemtemplate("Heavy Ballistic Vest", "finevest", "GFX\items\vest.x", "GFX\items\INV_vest.png", "", 0.022, "GFX\items\vest.png", "", $00, $09)
    local0\Field2 = $04
    local0 = createitemtemplate("Bulky Ballistic Vest", "veryfinevest", "GFX\items\vest.x", "GFX\items\INV_vest.png", "", 0.025, "GFX\items\vest.png", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Hazmat Suit", "hazmatsuit", "GFX\items\hazmat_suit.b3d", "GFX\items\INV_hazmat_suit.png", "", 0.013, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Hazmat Suit", "hazmatsuit2", "GFX\items\hazmat_suit.b3d", "GFX\items\INV_hazmat_suit.png", "", 0.013, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Heavy Hazmat Suit", "hazmatsuit3", "GFX\items\hazmat_suit.b3d", "GFX\items\INV_hazmat_suit.png", "", 0.013, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("cup", "cup", "GFX\items\cup.x", "GFX\items\INV_cup.png", "", 0.04, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Empty Cup", "emptycup", "GFX\items\cup.x", "GFX\items\INV_cup.png", "", 0.04, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-500-01", "scp500pill", "GFX\items\pill.b3d", "GFX\items\INV_scp_500_pill.png", "", 0.0001, "", "", $00, $09)
    local0\Field2 = $02
    entitycolor(local0\Field4, 255.0, 0.0, 0.0)
    local0 = createitemtemplate("First Aid Kit", "firstaid", "GFX\items\first_aid.x", "GFX\items\INV_first_aid.png", "", 0.05, "", "", $00, $09)
    local0 = createitemtemplate("Small First Aid Kit", "finefirstaid", "GFX\items\first_aid.x", "GFX\items\INV_first_aid.png", "", 0.03, "", "", $00, $09)
    local0 = createitemtemplate("Blue First Aid Kit", "firstaid2", "GFX\items\first_aid.x", "GFX\items\INV_first_aid(2).png", "", 0.03, "GFX\items\first_aid_kit(2).png", "", $00, $09)
    local0 = createitemtemplate("Strange Bottle", "veryfinefirstaid", "GFX\items\eye_drops.b3d", "GFX\items\INV_strange_bottle.png", "", 0.002, "GFX\items\strange_bottle.png", "", $00, $09)
    local0 = createitemtemplate("Gas Mask", "gasmask", "GFX\items\gas_mask.b3d", "GFX\items\INV_gas_mask.png", "", 0.02, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Gas Mask", "supergasmask", "GFX\items\gas_mask.b3d", "GFX\items\INV_gas_mask.png", "", 0.021, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Heavy Gas Mask", "gasmask3", "GFX\items\gas_mask.b3d", "GFX\items\INV_gas_mask.png", "", 0.021, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Origami", "misc", "GFX\items\origami.b3d", "GFX\items\INV_origami.png", "", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    createitemtemplate("Electronical components", "misc", "GFX\items\electronics.x", "GFX\items\INV_electronics.png", "", 0.0011, "", "", $00, $09)
    local0 = createitemtemplate("Metal Panel", "scp148", "GFX\items\metal_panel.x", "GFX\items\INV_metal_panel.png", "", roomscale, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-148 Ingot", "scp148ingot", "GFX\items\scp_148.x", "GFX\items\INV_scp_148.png", "", roomscale, "", "", $00, $09)
    local0\Field2 = $02
    createitemtemplate("S-NAV 300 Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INV_navigator.png", "GFX\items\navigator_HUD.png", 0.0008, "", "", $00, $09)
    createitemtemplate("S-NAV Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INV_navigator.png", "GFX\items\navigator_HUD.png", 0.0008, "", "", $00, $09)
    createitemtemplate("S-NAV Navigator Ultimate", "nav", "GFX\items\navigator.x", "GFX\items\INV_navigator.png", "GFX\items\navigator_HUD.png", 0.0008, "", "", $00, $09)
    createitemtemplate("S-NAV 310 Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INV_navigator.png", "GFX\items\navigator_HUD.png", 0.0008, "", "", $00, $09)
    createitemtemplate("Radio Transceiver", "radio", "GFX\items\radio.x", "GFX\items\INV_radio.png", "GFX\items\radio_HUD.png", 1.0, "", "", $00, $09)
    createitemtemplate("Radio Transceiver", "fineradio", "GFX\items\radio.x", "GFX\items\INV_radio.png", "GFX\items\radio_HUD.png", 1.0, "", "", $00, $09)
    createitemtemplate("Radio Transceiver", "veryfineradio", "GFX\items\radio.x", "GFX\items\INV_radio.png", "GFX\items\radio_HUD.png", 1.0, "", "", $00, $09)
    createitemtemplate("Radio Transceiver", "18vradio", "GFX\items\radio.x", "GFX\items\INV_radio.png", "GFX\items\radio_HUD.png", 1.02, "", "", $00, $09)
    local0 = createitemtemplate("Cigarette", "cigarette", "GFX\items\scp_420_j.x", "GFX\items\INV_scp_420_j.png", "", 0.0004, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Joint", "scp420s", "GFX\items\scp_420_j.x", "GFX\items\INV_scp_420_j.png", "", 0.0004, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Smelly Joint", "scp420s", "GFX\items\scp_420_j.x", "GFX\items\INV_scp_420_j.png", "", 0.0004, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Severed Hand", "hand", "GFX\items\severed_hand.b3d", "GFX\items\INV_severed_hand.png", "", 0.04, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Black Severed Hand", "hand2", "GFX\items\severed_hand.b3d", "GFX\items\INV_severed_hand(2).png", "", 0.04, "GFX\items\severed_hand(2).png", "", $00, $09)
    local0\Field2 = $02
    createitemtemplate("9V Battery", "bat", "GFX\items\battery.x", "GFX\items\INV_battery_9v.png", "", 0.008, "", "", $00, $09)
    createitemtemplate("18V Battery", "18vbat", "GFX\items\battery.x", "GFX\items\INV_battery_18v.png", "", 0.01, "GFX\items\battery_18V.png", "", $00, $09)
    createitemtemplate("Strange Battery", "killbat", "GFX\items\battery.x", "GFX\items\INV_strange_battery.png", "", 0.01, "GFX\items\strange_battery.png", "", $00, $09)
    createitemtemplate("Eyedrops", "fineeyedrops", "GFX\items\eye_drops.b3d", "GFX\items\INV_eye_drops.png", "", 0.0012, "GFX\items\eye_drops.png", "", $00, $09)
    createitemtemplate("Eyedrops", "supereyedrops", "GFX\items\eye_drops.b3d", "GFX\items\INV_eye_drops.png", "", 0.0012, "GFX\items\eye_drops.png", "", $00, $09)
    createitemtemplate("ReVision Eyedrops", "eyedrops", "GFX\items\eye_drops.b3d", "GFX\items\INV_eye_drops.png", "", 0.0012, "GFX\items\eye_drops.png", "", $00, $09)
    createitemtemplate("RedVision Eyedrops", "eyedrops2", "GFX\items\eye_drops.b3d", "GFX\items\INV_eye_drops_red.png", "", 0.0012, "GFX\items\eye_drops_red.png", "", $00, $09)
    local0 = createitemtemplate("SCP-714", "scp714", "GFX\items\scp_714.b3d", "GFX\items\INV_scp_714.png", "", 0.3, "", "", $00, $09)
    local0\Field2 = $03
    local0 = createitemtemplate("SCP-1025", "scp1025", "GFX\items\scp_1025.b3d", "GFX\items\INV_scp_1025.png", "", 0.1, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("SCP-513", "scp513", "GFX\items\scp_513.x", "GFX\items\INV_scp_513.png", "", 0.1, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Clipboard", "clipboard", "GFX\items\clipboard.b3d", "GFX\items\INV_clipboard.png", "", 0.003, "", "GFX\items\INV_clipboard2.png", $01, $09)
    local0 = createitemtemplate("SCP-1123", "scp1123", "GFX\items\scp_1123.b3d", "GFX\items\INV_scp_1123.png", "", 0.015, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Night Vision Goggles", "supernv", "GFX\items\night_vision_goggles.b3d", "GFX\items\INV_super_night_vision_goggles.png", "", 0.02, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Night Vision Goggles", "nvgoggles", "GFX\items\night_vision_goggles.b3d", "GFX\items\INV_night_vision_goggles.png", "", 0.02, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Night Vision Goggles", "finenvgoggles", "GFX\items\night_vision_goggles.b3d", "GFX\items\INV_very_fine_night_vision_goggles.png", "", 0.02, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Syringe", "syringe", "GFX\items\syringe.b3d", "GFX\items\INV_syringe.png", "", 0.005, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Syringe", "finesyringe", "GFX\items\syringe.b3d", "GFX\items\INV_syringe.png", "", 0.005, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Syringe", "veryfinesyringe", "GFX\items\syringe.b3d", "GFX\items\INV_syringe.png", "", 0.005, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-1499", "scp1499", "GFX\items\scp_1499.b3d", "GFX\items\INV_scp_1499.png", "", 0.023, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-1499", "super1499", "GFX\items\scp_1499.b3d", "GFX\items\INV_scp_1499.png", "", 0.023, "", "", $00, $09)
    local0\Field2 = $02
    createitemtemplate("Emily Ross' Badge", "badge", "GFX\items\badge.x", "GFX\items\INV_Emily_badge.png", "GFX\items\Emily_badge_HUD.png", 0.0001, "GFX\items\Emily_badge.png", "", $00, $09)
    local0 = createitemtemplate("Lost Key", "key", "GFX\items\key.b3d", "GFX\items\INV_key.png", "", 0.0028, "", "", $00, $09)
    local0\Field2 = $03
    local0 = createitemtemplate("Disciplinary Hearing DH-S-4137-17092", "oldpaper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\dh.s", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Coin", "coin", "GFX\items\coin.b3d", "GFX\items\INV_coin.png", "", 0.0005, "", "", $00, $09)
    local0\Field2 = $03
    local0 = createitemtemplate("Movie Ticket", "ticket", "GFX\items\ticket.b3d", "GFX\items\INV_ticket.png", "GFX\items\ticket_HUD.png", 0.002, "GFX\items\ticket.png", "", $00, $0B)
    local0\Field2 = $00
    createitemtemplate("Old Badge", "badge", "GFX\items\badge.x", "GFX\items\INV_d_9341_badge.png", "GFX\items\d_9341_badge_HUD.png", 0.0001, "GFX\items\d_9341_badge.png", "", $00, $0B)
    local0 = createitemtemplate("Quarter", "25ct", "GFX\items\coin.b3d", "GFX\items\INV_coin.png", "", 0.0005, "GFX\items\coin.png", "", $00, $0B)
    local0\Field2 = $03
    local0 = createitemtemplate("Wallet", "wallet", "GFX\items\wallet.b3d", "GFX\items\INV_wallet.png", "", 0.0005, "", "", $01, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-427", "scp427", "GFX\items\scp_427.b3d", "GFX\items\INV_scp_427.png", "", 0.001, "", "", $00, $09)
    local0\Field2 = $03
    local0 = createitemtemplate("Upgraded pill", "scp500pilldeath", "GFX\items\pill.b3d", "GFX\items\INV_scp_500_pill.png", "", 0.0001, "", "", $00, $09)
    local0\Field2 = $02
    entitycolor(local0\Field4, 255.0, 0.0, 0.0)
    local0 = createitemtemplate("Pill", "pill", "GFX\items\pill.b3d", "GFX\items\INV_pill.png", "", 0.0001, "", "", $00, $09)
    local0\Field2 = $02
    entitycolor(local0\Field4, 255.0, 255.0, 255.0)
    local0 = createitemtemplate("Sticky Note", "paper", "GFX\items\note.x", "GFX\items\INV_note(2).png", "GFX\items\note_682.png", (1.0 / 400.0), "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("The Modular Site Project", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_MSP.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Research Sector-02 Scheme", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_map.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-427", "paper", "GFX\items\paper.x", "GFX\items\INV_paper_bloody.png", "GFX\items\doc_427.png", 0.003, "GFX\items\paper_bloody.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Syringe", "syringeinf", "GFX\items\syringe.b3d", "GFX\items\INV_syringe_infected.png", "", 0.005, "GFX\items\syringe_infected.png", "", $00, $09)
    local0\Field2 = $02
    createitemtemplate("Level 0 Key Card", "key0", "GFX\items\key_card.x", "GFX\items\INV_key_card_lvl_0.png", "", 0.0004, "GFX\items\key_card_lvl_0.png", "", $00, $09)
    createitemtemplate("Level 6 Key Card", "key6", "GFX\items\key_card.x", "GFX\items\INV_key_card_lvl_6.png", "", 0.0004, "GFX\items\key_card_lvl_6.png", "", $00, $09)
    local0 = createitemtemplate("Paper Strips", "paperstrips", "GFX\items\paper_strips.x", "GFX\items\INV_paper_strips.png", "", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Field Agent Log #235-001-CO5", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_O5.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Groups of Interest Log", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_O5(2).png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Unknown Document", "paper", "GFX\items\paper.x", "GFX\items\INV_paper_bloody.png", "GFX\items\doc_unknown.png", 0.003, "GFX\items\paper_bloody.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Unknown Note", "paper", "GFX\items\note.x", "GFX\items\INV_note_bloody.png", "GFX\items\unknown_note.png", 0.003, "GFX\items\note_bloody.png", "", $00, $09)
    local0\Field2 = $00
    createitemtemplate("SCP-215", "scp215", "GFX\items\scp_215.b3d", "GFX\items\INV_scp_215.png", "", 0.022, "", "", $01, $09)
    createitemtemplate("Glasses Case", "glassescase", "GFX\items\glasses_case.b3d", "GFX\items\INV_glasses_case.png", "", 0.022, "", "", $01, $09)
    local0 = createitemtemplate("SCP-1033-RU", "scp1033ru", "GFX\items\scp_1033_ru.b3d", "GFX\items\INV_scp_1033_ru.png", "", 0.7, "", "", $00, $09)
    local0\Field2 = $03
    local0 = createitemtemplate("SCP-1033-RU", "super1033ru", "GFX\items\scp_1033_ru.b3d", "GFX\items\INV_scp_1033_ru.png", "", 0.7, "", "", $00, $09)
    local0\Field2 = $03
    local0 = createitemtemplate("SCP-207", "scp207", "GFX\items\scp_207.b3d", "GFX\items\INV_scp_207.png", "", 0.14, "", "", $00, $09)
    local0\Field2 = $05
    local0 = createitemtemplate("Document SCP-178", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_178.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-215", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_215.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-198", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_198.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-447", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_447.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-207", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_207.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-402", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_402.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-1033-RU", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_1033_ru.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-357", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_357.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-XXX", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_970_1162.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Incident O5-14", "paper", "GFX\items\paper.x", "GFX\items\INV_burnt_note.png", "GFX\items\doc_O5_14.png", (1.0 / 400.0), "GFX\items\burnt_note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("SCP-500", "scp500", "GFX\items\scp_500_bottle.b3d", "GFX\items\INV_scp_500_bottle.png", "", 0.05, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-402", "scp402", "GFX\items\scp_402.b3d", "GFX\items\INV_scp_402.png", "", 0.075, "", "", $00, $09)
    local0\Field2 = $03
    local0 = createitemtemplate("SCP-357", "scp357", "GFX\items\scp_357.b3d", "GFX\items\INV_scp_357.png", "", 0.04, "", "", $00, $09)
    local0\Field2 = $02
    createitemtemplate("Minty 9V Battery", "mintbat", "GFX\items\battery.x", "GFX\items\INV_scp_447_battery_9v.png", "", 0.008, "GFX\items\scp_447_battery_9V.png", "", $00, $09)
    createitemtemplate("Minty 18V Battery", "mint18vbat", "GFX\items\battery.x", "GFX\items\INV_scp_447_battery_18v.png", "", 0.01, "GFX\items\scp_447_battery_18V.png", "", $00, $09)
    local0 = createitemtemplate("Severed Hand", "hand3", "GFX\items\severed_hand.b3d", "GFX\items\INV_severed_hand(3).png", "", 0.04, "GFX\items\severed_hand(3).png", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Data Report", "paper", "GFX\items\paper.x", "GFX\items\INV_paper_bloody.png", "GFX\items\doc_data.png", 0.003, "GFX\items\paper_bloody.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("SCP-085 Note", "paper", "GFX\items\note.x", "GFX\items\INV_note.png", "GFX\items\note_085.png", 0.003, "GFX\items\note3.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("References Document", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_references.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Dr. Clef's Note", "paper", "GFX\items\paper.x", "GFX\items\INV_note.png", "GFX\items\note_Clef.png", 0.003, "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Ballistic Helmet", "helmet", "GFX\items\helmet.x", "GFX\items\INV_helmet.png", "", 0.02, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Upgraded Minty Pill", "mintscp500pilldeath", "GFX\items\pill.b3d", "GFX\items\INV_scp_447_pill.png", "", 0.0001, "", "", $00, $09)
    local0\Field2 = $02
    entitycolor(local0\Field4, 0.0, 140.0, 0.0)
    local0 = createitemtemplate("Minty Pill", "mintpill", "GFX\items\pill.b3d", "GFX\items\INV_scp_447_pill.png", "", 0.0001, "", "", $00, $09)
    local0\Field2 = $02
    entitycolor(local0\Field4, 0.0, 140.0, 0.0)
    createitemtemplate("SCP-005", "scp005", "GFX\items\scp_005.b3d", "GFX\items\INV_scp_005.png", "", 0.0004, "", "", $00, $09)
    local0 = createitemtemplate("Document SCP-009", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_009.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-409", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_409.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    createitemtemplate("SCP-178", "scp178", "GFX\items\scp_178.b3d", "GFX\items\INV_scp_178.png", "", 0.02, "", "", $01, $09)
    local0 = createitemtemplate("Document SCP-005", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_005.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Note from Maynard", "paper", "GFX\items\note.x", "GFX\items\INV_note.png", "GFX\items\note_Maynard.png", (1.0 / 400.0), "GFX\items\note.png", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Minty SCP-500-01", "mintscp500pill", "GFX\items\pill.b3d", "GFX\items\INV_scp_447_pill.png", "", 0.0001, "", "", $00, $09)
    local0\Field2 = $02
    entitycolor(local0\Field4, 0.0, 140.0, 0.0)
    local0 = createitemtemplate("Minty First Aid Kit", "mintfirstaid", "GFX\items\first_aid.x", "GFX\items\INV_scp_447_first_aid.png", "", 0.05, "GFX\items\scp_447_first_aid_kit.png", "", $00, $09)
    local0 = createitemtemplate("Minty Small First Aid Kit", "mintfinefirstaid", "GFX\items\first_aid.x", "GFX\items\INV_scp_447_first_aid.png", "", 0.03, "GFX\items\scp_447_first_aid_kit.png", "", $00, $09)
    local0 = createitemtemplate("Minty Blue First Aid Kit", "mintfirstaid2", "GFX\items\first_aid.x", "GFX\items\INV_scp_447_first_aid(2).png", "", 0.03, "GFX\items\scp_447_first_aid_kit(2).png", "", $00, $09)
    local0 = createitemtemplate("Minty Strange Bottle", "mintveryfinefirstaid", "GFX\items\eye_drops.b3d", "GFX\items\INV_scp_447_strange_bottle.png", "", 0.002, "GFX\items\scp_447_strange_bottle.png", "", $00, $09)
    createitemtemplate("Minty Eyedrops", "mintfineeyedrops", "GFX\items\eye_drops.b3d", "GFX\items\INV_scp_447_eye_drops.png", "", 0.0012, "GFX\items\scp_447_eye_drops.png", "", $00, $09)
    createitemtemplate("Minty Eyedrops", "mintsupereyedrops", "GFX\items\eye_drops.b3d", "GFX\items\INV_scp_447_eye_drops.png", "", 0.0012, "GFX\items\scp_447_eye_drops.png", "", $00, $09)
    createitemtemplate("Minty ReVision Eyedrops", "minteyedrops", "GFX\items\eye_drops.b3d", "GFX\items\INV_scp_447_eye_drops.png", "", 0.0012, "GFX\items\scp_447_eye_drops.png", "", $00, $09)
    createitemtemplate("Minty RedVision Eyedrops", "minteyedrops2", "GFX\items\eye_drops.b3d", "GFX\items\INV_scp_447_eye_drops_red.png", "", 0.0012, "GFX\items\scp_447_eye_drops_red.png", "", $00, $09)
    local0 = createitemtemplate("SCP-447", "scp447", "GFX\items\scp_447.b3d", "GFX\items\INV_scp_447.png", "", 0.003, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Painkiller", "morphine", "GFX\items\syringe.b3d", "GFX\items\INV_syringe.png", "", 0.005, "GFX\items\syringe.png", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Document SCP-1079", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_1079.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-650", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_650.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("Corrosive Ballistic Vest", "corrvest", "GFX\items\vest.x", "GFX\items\INV_vest.png", "", 0.02, "GFX\items\corrosive_vest.png", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-1079-01", "scp1079sweet", "GFX\items\scp_1079_sweet.b3d", "GFX\items\INV_scp_1079_sweet.png", "", 0.01, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-1079", "scp1079", "GFX\items\scp_1079_packet.b3d", "GFX\items\INV_scp_1079_packet.png", "", 0.18, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("Document SCP-457", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_457.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("SCP-457 Addendum", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_457_ad.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    local0 = createitemtemplate("SCP-198", "scp198", "GFX\items\scp_198.b3d", "GFX\items\INV_scp_198.png", "", 0.04, "", "", $00, $09)
    local0\Field2 = $02
    local0 = createitemtemplate("SCP-109", "scp109", "GFX\items\scp_109.b3d", "GFX\items\INV_scp_109.png", "", 0.0009, "", "", $01, $09)
    local0\Field2 = $05
    local0 = createitemtemplate("Document SCP-109", "paper", "GFX\items\paper.x", "GFX\items\INV_paper.png", "GFX\items\doc_109.png", 0.003, "", "", $00, $09)
    local0\Field2 = $00
    For local0 = Each itemtemplates
        If (local0\Field14 <> $00) Then
            If (local0\Field15 <> "") Then
                For local1 = Each itemtemplates
                    If (((local1 <> local0) And (local1\Field14 = local0\Field14)) <> 0) Then
                        local1\Field14 = $00
                    EndIf
                Next
            EndIf
            freetexture(local0\Field14)
            local0\Field14 = $00
        EndIf
    Next
    Return $00
End Function
