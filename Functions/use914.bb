Function use914%(arg0.items, arg1$, arg2#, arg3#, arg4#)
    Local local0.items
    Local local3.decals
    Local local5.npcs
    Local local8%
    Local local11.items
    Local local22%
    Local local29.items
    Local local30.items
    Local local31.items
    Local local47%
    refineditems = (refineditems + $01)
    If (usedconsole <> $01) Then
    EndIf
    Select arg0\Field3\Field0
        Case "Gas Mask","Heavy Gas Mask"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                    removeitem(arg0)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine","very fine"
                    local0 = createitem("Gas Mask", "supergasmask", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
            End Select
        Case "SCP-1499"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                    removeitem(arg0)
                Case "1:1"
                    local0 = createitem("Gas Mask", "gasmask", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
                Case "fine"
                    local0 = createitem("SCP-1499", "super1499", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
                Case "very fine"
                    local5 = createnpc($0F, arg2, arg3, arg4)
                    local5\Field9 = 1.0
                    local5\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\SCP\1499\Triggered.ogg"))
                    local5\Field17 = playsound2(local5\Field16, camera, local5\Field4, 20.0, 1.0)
                    local5\Field11 = 1.0
                    removeitem(arg0)
            End Select
        Case "Ballistic Vest"
            Select arg1
                Case "rough"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                    removeitem(arg0)
                Case "coarse"
                    local0 = createitem("Corrosive Ballistic Vest", "corrvest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine"
                    local0 = createitem("Heavy Ballistic Vest", "finevest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
                Case "very fine"
                    local0 = createitem("Bulky Ballistic Vest", "veryfinevest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
            End Select
        Case "Clipboard"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Paper Strips", "paperstrips", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    For local8 = $00 To $13 Step $01
                        If (arg0\Field21[local8] <> Null) Then
                            removeitem(arg0\Field21[local8])
                        EndIf
                        arg0\Field21[local8] = Null
                    Next
                    removeitem(arg0)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine"
                    arg0\Field23 = (Int max(arg0\Field14, 15.0))
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "very fine"
                    arg0\Field23 = (Int max(arg0\Field14, 20.0))
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
            End Select
        Case "Night Vision Goggles"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                    removeitem(arg0)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine"
                    local0 = createitem("Night Vision Goggles", "finenvgoggles", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
                Case "very fine"
                    local0 = createitem("Night Vision Goggles", "supernv", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local0\Field13 = 1000.0
                    removeitem(arg0)
            End Select
        Case "Metal Panel","SCP-148 Ingot"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("SCP-148 Ingot", "scp148ingot", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
                Case "1:1","fine","very fine"
                    local0 = Null
                    For local11 = Each items
                        If ((((local11 <> arg0) And (local11\Field1 <> $00)) And (local11\Field15 = $00)) <> 0) Then
                            If ((180.0 * roomscale) > distance(entityx(local11\Field1, $01), entityz(local11\Field1, $01), entityx(arg0\Field1, $01), entityz(arg0\Field1, $01))) Then
                                local0 = local11
                                Exit
                            ElseIf ((180.0 * roomscale) > distance(entityx(local11\Field1, $01), entityz(local11\Field1, $01), arg2, arg4)) Then
                                local0 = local11
                                Exit
                            EndIf
                        EndIf
                    Next
                    If (local0 <> Null) Then
                        Select local0\Field3\Field1
                            Case "gasmask","supergasmask"
                                removeitem(local0)
                                removeitem(arg0)
                                local0 = createitem("Heavy Gas Mask", "gasmask3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            Case "vest"
                                removeitem(local0)
                                removeitem(arg0)
                                local0 = createitem("Heavy Ballistic Vest", "finevest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            Case "hazmatsuit","hazmatsuit2"
                                removeitem(local0)
                                removeitem(arg0)
                                local0 = createitem("Heavy Hazmat Suit", "hazmatsuit3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        End Select
                    ElseIf (arg0\Field3\Field0 = "SCP-148 Ingot") Then
                        local0 = createitem("Metal Panel", "scp148", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        removeitem(arg0)
                    Else
                        positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                        resetentity(arg0\Field1)
                    EndIf
            End Select
        Case "Severed Hand","Black Severed Hand"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($03, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1","fine"
                    If (arg0\Field3\Field1 = "hand") Then
                        If (rand($02, $01) = $01) Then
                            local0 = createitem("Black Severed Hand", "hand2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Else
                            local0 = createitem("Severed Hand", "hand3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        EndIf
                    ElseIf (arg0\Field3\Field1 = "hand3") Then
                        If (rand($02, $01) = $01) Then
                            local0 = createitem("Black Severed Hand", "hand2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Else
                            local0 = createitem("Severed Hand", "hand", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        EndIf
                    ElseIf (rand($02, $01) = $01) Then
                        local0 = createitem("Severed Hand", "hand3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Severed Hand", "hand", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case "very fine"
                    local0 = createitem("SCP-447", "scp447", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "First Aid Kit","Blue First Aid Kit"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Blue First Aid Kit", "firstaid2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("First Aid Kit", "firstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case "fine"
                    local0 = createitem("Small First Aid Kit", "finefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Strange Bottle", "veryfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Level 0 Key Card","Level 1 Key Card","Level 2 Key Card","Level 3 Key Card","Level 4 Key Card","Level 5 Key Card","Level 6 Key Card"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.07
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine"
                    Select arg0\Field3\Field0
                        Case "Level 0 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    local0 = createitem("Level 1 Key Card", "key1", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($05, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 1 Key Card", "key1", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($04, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 1 Key Card", "key1", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case "Level 1 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($05, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($04, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case "Level 2 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($04, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($03, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case "Level 3 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    If (rand($0A, $01) = $01) Then
                                        local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $01
                                    If (rand($0F, $01) = $01) Then
                                        local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($14, $01) = $01) Then
                                        local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case "Level 4 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($04, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($03, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case "Level 5 Key Card"
                            local22 = $00
                            For local8 = $00 To $3A Step $01
                                If (achievements(local8) = $01) Then
                                    local22 = (local22 + $01)
                                EndIf
                            Next
                            Select selecteddifficulty\Field5
                                Case $00
                                    If (rand($00, ($AE - ((local22 - $01) * $03))) = $00) Then
                                        local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    ElseIf (rand($04, $01) = $01) Then
                                        local0 = createitem("Level 6 Key Card", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $01
                                    If (rand($00, ($E8 - ((local22 - $01) * $03))) = $00) Then
                                        local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    ElseIf (rand($05, $01) = $01) Then
                                        local0 = createitem("Level 6 Key Card", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($00, ($122 - ((local22 - $01) * $03))) = $00) Then
                                        local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    ElseIf (rand($06, $01) = $01) Then
                                        local0 = createitem("Level 6 Key Card", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                        Case "Level 6 Key Card"
                            Select selecteddifficulty\Field5
                                Case $00
                                    local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $01
                                    If (rand($04, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                                Case $02
                                    If (rand($03, $01) = $01) Then
                                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    Else
                                        local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                    EndIf
                            End Select
                    End Select
                Case "very fine"
                    local22 = $00
                    For local8 = $00 To $3A Step $01
                        If (achievements(local8) = $01) Then
                            local22 = (local22 + $01)
                        EndIf
                    Next
                    Select selecteddifficulty\Field5
                        Case $00
                            If (rand($00, ($AE - ((local22 - $01) * $03))) = $00) Then
                                local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            ElseIf (rand($04, $01) = $01) Then
                                local0 = createitem("Level 6 Key Card", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            Else
                                local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            EndIf
                        Case $01
                            If (rand($00, ($E8 - ((local22 - $01) * $03))) = $00) Then
                                local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            ElseIf (rand($05, $01) = $01) Then
                                local0 = createitem("Level 6 Key Card", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            Else
                                local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            EndIf
                        Case $02
                            If (rand($00, ($122 - ((local22 - $01) * $03))) = $00) Then
                                If (rand($06, $01) = $01) Then
                                    local0 = createitem("Level 6 Key Card", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                EndIf
                            Else
                                local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            EndIf
                    End Select
            End Select
            removeitem(arg0)
        Case "Key Card Omni"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.07
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case "fine","very fine"
                    local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Playing Card","Coin","Quarter"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.07
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("Level 0 Key Card", "key0", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine","very fine"
                    local0 = createitem("Level 1 Key Card", "key1", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Mastercard"
            Select arg1
                Case "rough"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.07
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "coarse"
                    local0 = createitem("Quarter", "25ct", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local29 = createitem("Quarter", "25ct", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local30 = createitem("Quarter", "25ct", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local31 = createitem("Quarter", "25ct", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    entitytype(local29\Field1, $03, $00)
                    entitytype(local30\Field1, $03, $00)
                    entitytype(local31\Field1, $03, $00)
                Case "1:1"
                    local0 = createitem("Level 0 Key Card", "key0", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine","very fine"
                    local0 = createitem("Level 1 Key Card", "key1", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "S-NAV 300 Navigator","S-NAV 310 Navigator","S-NAV Navigator","S-NAV Navigator Ultimate"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Electronical components", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "1:1"
                    local0 = createitem("S-NAV Navigator", "nav", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local0\Field13 = 100.0
                Case "fine"
                    local0 = createitem("S-NAV 310 Navigator", "nav", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local0\Field13 = 100.0
                Case "very fine"
                    local0 = createitem("S-NAV Navigator Ultimate", "nav", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local0\Field13 = 101.0
            End Select
            removeitem(arg0)
        Case "Radio Transceiver"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Electronical components", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "1:1"
                    local0 = createitem("Radio Transceiver", "18vradio", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local0\Field13 = 100.0
                Case "fine"
                    local0 = createitem("Radio Transceiver", "fineradio", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local0\Field13 = 101.0
                Case "very fine"
                    local0 = createitem("Radio Transceiver", "veryfineradio", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    local0\Field13 = 101.0
            End Select
            removeitem(arg0)
        Case "SCP-513"
            Select arg1
                Case "rough","coarse"
                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\513\914Refine.ogg")))
                    For local5 = Each npcs
                        If (local5\Field5 = $0A) Then
                            removenpc(local5)
                        EndIf
                    Next
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1","fine","very fine"
                    local0 = createitem("SCP-513", "scp513", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Some SCP-420-J","Cigarette"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("Cigarette", "cigarette", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), $00, $00, $00, 1.0, $00)
                Case "fine"
                    local0 = createitem("Joint", "scp420s", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Smelly Joint", "scp420s", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "9V Battery","18V Battery","Strange Battery"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("18V Battery", "18vbat", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine"
                    local0 = createitem("Strange Battery", "killbat", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Strange Battery", "killbat", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "ReVision Eyedrops"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("RedVision Eyedrops", "eyedrops2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine"
                    local0 = createitem("Eyedrops", "fineeyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Eyedrops", "supereyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Eyedrops"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("RedVision Eyedrops", "eyedrops2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("ReVision Eyedrops", "eyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case "fine"
                    local0 = createitem("Eyedrops", "fineeyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Eyedrops", "supereyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "RedVision Eyedrops"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("ReVision Eyedrops", "eyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine"
                    local0 = createitem("Eyedrops", "fineeyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Eyedrops", "supereyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Hazmat Suit"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("Hazmat Suit", "hazmatsuit", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine"
                    local0 = createitem("Hazmat Suit", "hazmatsuit2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Hazmat Suit", "hazmatsuit2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Syringe"
            Select arg0\Field3\Field1
                Case "syringe"
                    Select arg1
                        Case "rough","coarse"
                            local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                            local3\Field2 = 0.07
                            scalesprite(local3\Field0, local3\Field2, local3\Field2)
                        Case "1:1"
                            local0 = createitem("Small First Aid Kit", "finefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Case "fine"
                            local0 = createitem("Syringe", "finesyringe", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Case "very fine"
                            local0 = createitem("Syringe", "veryfinesyringe", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    End Select
                Case "finesyringe"
                    Select arg1
                        Case "rough"
                            local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                            local3\Field2 = 0.07
                            scalesprite(local3\Field0, local3\Field2, local3\Field2)
                        Case "coarse"
                            local0 = createitem("First Aid Kit", "firstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Case "1:1"
                            local0 = createitem("Blue First Aid Kit", "firstaid2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Case "fine","very fine"
                            local0 = createitem("Syringe", "veryfinesyringe", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    End Select
                Case "veryfinesyringe"
                    Select arg1
                        Case "rough","coarse","1:1","fine"
                            local0 = createitem("Electronical components", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Case "very fine"
                            local5 = createnpc($01, arg2, arg3, arg4)
                            local5\Field9 = 2.0
                    End Select
                Case "syringeinf"
                    Select arg1
                        Case "rough","coarse"
                            local3 = createdecal($15, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                            local3\Field2 = 0.07
                            scalesprite(local3\Field0, local3\Field2, local3\Field2)
                        Case "1:1"
                            local5 = createnpc($01, arg2, arg3, arg4)
                            local5\Field9 = 2.0
                        Case "fine"
                            local0 = createitem("Syringe", "syringe", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Case "very fine"
                            local0 = createitem("Blue First Aid Kit", "firstaid2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    End Select
            End Select
            removeitem(arg0)
        Case "SCP-500-01","Upgraded pill","Pill"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("Pill", "pill", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
                Case "fine"
                    local47 = $00
                    For local29 = Each items
                        If (local29\Field3\Field1 = "scp427") Then
                            local47 = $01
                            Exit
                        EndIf
                    Next
                    If (local47 = $00) Then
                        local0 = createitem("SCP-427", "scp427", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Upgraded pill", "scp500pilldeath", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                    removeitem(arg0)
                Case "very fine"
                    local0 = createitem("Upgraded pill", "scp500pilldeath", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
            End Select
        Case "Wallet"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Paper Strips", "paperstrips", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    For local8 = $00 To $13 Step $01
                        If (arg0\Field21[local8] <> Null) Then
                            removeitem(arg0\Field21[local8])
                        EndIf
                        arg0\Field21[local8] = Null
                    Next
                    removeitem(arg0)
                Case "1:1"
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "fine"
                    arg0\Field23 = (Int max(arg0\Field14, 15.0))
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
                Case "very fine"
                    arg0\Field23 = (Int max(arg0\Field14, 20.0))
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
            End Select
        Case "SCP-447"
            Select arg1
                Case "rough","coarse"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Black Severed Hand", "hand2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    ElseIf (rand($02, $01) = $01) Then
                        local0 = createitem("Severed Hand", "hand", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Severed Hand", "hand3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                    removeitem(arg0)
                Case "1:1","fine","very fine"
                    local0 = Null
                    For local11 = Each items
                        If ((((local11 <> arg0) And (local11\Field1 <> $00)) And (local11\Field15 = $00)) <> 0) Then
                            If ((180.0 * roomscale) > distance(entityx(local11\Field1, $01), entityz(local11\Field1, $01), entityx(arg0\Field1, $01), entityz(arg0\Field1, $01))) Then
                                local0 = local11
                                Exit
                            ElseIf ((180.0 * roomscale) > distance(entityx(local11\Field1, $01), entityz(local11\Field1, $01), arg2, arg4)) Then
                                local0 = local11
                                Exit
                            EndIf
                        EndIf
                    Next
                    If (local0 <> Null) Then
                        Select local0\Field3\Field1
                            Case "scp500pill"
                                removeitem(local0)
                                removeitem(arg0)
                                local0 = createitem("Minty SCP-500-01", "mintscp500pill", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                giveachievement($30, $01)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "firstaid"
                                removeitem(local0)
                                removeitem(arg0)
                                local0 = createitem("Minty First Aid Kit", "mintfirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                giveachievement($30, $01)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "finefirstaid"
                                removeitem(local0)
                                removeitem(arg0)
                                local0 = createitem("Minty Small First Aid Kit", "mintfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                giveachievement($30, $01)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "firstaid2"
                                removeitem(local0)
                                removeitem(arg0)
                                local0 = createitem("Minty Blue First Aid Kit", "mintfirstaid2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                giveachievement($30, $01)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "veryfinefirstaid"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                local0 = createitem("Minty Strange Bottle", "mintveryfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "eyedrops"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                local0 = createitem("Minty ReVision Eyedrops", "minteyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "eyedrops2"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                local0 = createitem("Minty RedVision Eyedrops", "minteyedrops2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "fineeyedrops"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                local0 = createitem("Minty Eyedrops", "mintfineeyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "supereyedrops"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                local0 = createitem("Minty Eyedrops", "mintsupereyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "bat"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                local0 = createitem("Minty 9V Battery", "mintbat", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "18vbat"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                local0 = createitem("Minty 18V Battery", "mint18vbat", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "key0"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                If (rand($04, $01) = $01) Then
                                    local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                EndIf
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "key1"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                If (rand($05, $01) = $01) Then
                                    local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                EndIf
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "key2"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                If (rand($06, $01) = $01) Then
                                    local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                EndIf
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "key3"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                If (rand($08, $01) = $01) Then
                                    local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                EndIf
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "key4"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                If (rand($0A, $01) = $01) Then
                                    local0 = createitem("Level 6 Key Card", "key6", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Else
                                    local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                EndIf
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                            Case "key5"
                                removeitem(local0)
                                removeitem(arg0)
                                giveachievement($30, $01)
                                local3 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                                local3\Field2 = 0.2
                                entityalpha(local3\Field0, 0.6)
                                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                                For local8 = $00 To $3A Step $01
                                    If (achievements(local8) = $01) Then
                                        local22 = (local22 + $01)
                                    EndIf
                                Next
                                Select selecteddifficulty\Field5
                                    Case $00
                                        If (rand($00, ($AE - ((local22 - $01) * $03))) = $00) Then
                                            local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        ElseIf (rand($04, $01) = $01) Then
                                            local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        Else
                                            local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        EndIf
                                    Case $01
                                        If (rand($00, ($E8 - ((local22 - $01) * $03))) = $00) Then
                                            local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        ElseIf (rand($05, $01) = $01) Then
                                            local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        Else
                                            local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        EndIf
                                    Case $02
                                        If (rand($00, ($122 - ((local22 - $01) * $03))) = $00) Then
                                            local0 = createitem("Key Card Omni", "key7", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        ElseIf (rand($06, $01) = $01) Then
                                            local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        Else
                                            local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                        EndIf
                                End Select
                        End Select
                    ElseIf (arg0\Field3\Field0 = "SCP-148 Ingot") Then
                        local0 = createitem("Metal Panel", "scp148", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        removeitem(arg0)
                    Else
                        positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                        resetentity(arg0\Field1)
                    EndIf
            End Select
        Case "Minty SCP-500-01","Upgraded Minty Pill","Minty Pill"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("Minty Pill", "mintpill", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
                Case "fine"
                    local47 = $00
                    For local29 = Each items
                        If (local29\Field3\Field1 = "scp427") Then
                            local47 = $01
                            Exit
                        EndIf
                    Next
                    If (local47 = $00) Then
                        local0 = createitem("SCP-427", "scp427", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Upgraded Minty Pill", "mintscp500pilldeath", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                    removeitem(arg0)
                Case "very fine"
                    local0 = createitem("Upgraded Minty Pill", "mintscp500pilldeath", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    removeitem(arg0)
            End Select
        Case "Minty First Aid Kit","Minty Blue First Aid Kit"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Minty Blue First Aid Kit", "mintfirstaid2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Minty First Aid Kit", "mintfirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case "fine"
                    local0 = createitem("Minty Small First Aid Kit", "mintfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Minty Strange Bottle", "mintveryfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Minty Strange Bottle"
            Select arg1
                Case "rough"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "coarse"
                    local0 = createitem("Minty Blue First Aid Kit", "mintfirstaid2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Minty Small First Aid Kit", "mintfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Minty Strange Bottle", "mintveryfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case "fine"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Minty Small First Aid Kit", "mintfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Minty Strange Bottle", "mintveryfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case "very fine"
                    local0 = createitem("Minty Strange Bottle", "mintveryfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Minty Small First Aid Kit"
            Select arg1
                Case "rough"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.12
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "coarse"
                    local0 = createitem("Minty First Aid Kit", "mintfirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Minty Small First Aid Kit", "mintfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    Else
                        local0 = createitem("Painkiller", "morphine", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    EndIf
                Case "fine","very fine"
                    local0 = createitem("Minty Strange Bottle", "mintveryfinefirstaid", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Minty ReVision Eyedrops","Minty RedVision Eyedrops","Minty Eyedrops"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("Minty RedVision Eyedrops", "minteyedrops2", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine"
                    local0 = createitem("Minty Eyedrops", "mintfineeyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "very fine"
                    local0 = createitem("Minty Eyedrops", "mintsupereyedrops", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "SCP-1033-RU"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.2
                    entityalpha(local3\Field0, 0.8)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    If (arg0\Field3\Field1 = "scp1033ru") Then
                        local0 = createitem("SCP-1033-RU", "scp1033ru", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        i_1033ru\Field0 = $64
                        i_1033ru\Field1 = $00
                    Else
                        local0 = createitem("SCP-1033-RU", "super1033ru", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        i_1033ru\Field0 = $C8
                        i_1033ru\Field1 = $00
                    EndIf
                Case "fine","very fine"
                    local0 = createitem("SCP-1033-RU", "super1033ru", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Case "Ballistic Helmet"
            Select arg1
                Case "rough","coarse"
                    local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local3\Field2 = 0.07
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Case "1:1"
                    local0 = createitem("Ballistic Vest", "vest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                Case "fine","very fine"
                    local0 = createitem("Heavy Ballistic Vest", "finevest", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
            End Select
            removeitem(arg0)
        Default
            Select arg0\Field3\Field1
                Case "cup"
                    Select arg1
                        Case "rough","coarse"
                            local3 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                            local3\Field2 = 0.2
                            entityalpha(local3\Field0, 0.8)
                            scalesprite(local3\Field0, local3\Field2, local3\Field2)
                        Case "1:1"
                            local0 = createitem("cup", "cup", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            local0\Field0 = arg0\Field0
                            local0\Field5 = ($FF - arg0\Field5)
                            local0\Field6 = ($FF - arg0\Field6)
                            local0\Field7 = ($FF - arg0\Field7)
                        Case "fine"
                            local0 = createitem("cup", "cup", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            local0\Field0 = arg0\Field0
                            local0\Field13 = 1.0
                            local0\Field5 = (Int min(((Float arg0\Field5) * rnd(0.9, 1.1)), 255.0))
                            local0\Field6 = (Int min(((Float arg0\Field6) * rnd(0.9, 1.1)), 255.0))
                            local0\Field7 = (Int min(((Float arg0\Field7) * rnd(0.9, 1.1)), 255.0))
                        Case "very fine"
                            local0 = createitem("cup", "cup", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            local0\Field0 = arg0\Field0
                            local0\Field13 = max((local0\Field13 * 2.0), 2.0)
                            local0\Field5 = (Int min(((Float arg0\Field5) * rnd(0.5, 1.5)), 255.0))
                            local0\Field6 = (Int min(((Float arg0\Field6) * rnd(0.5, 1.5)), 255.0))
                            local0\Field7 = (Int min(((Float arg0\Field7) * rnd(0.5, 1.5)), 255.0))
                            If (rand($05, $01) = $01) Then
                                explosiontimer = 135.0
                            EndIf
                    End Select
                    removeitem(arg0)
                Case "paper"
                    Select arg1
                        Case "rough","coarse"
                            local0 = createitem("Paper Strips", "paperstrips", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                        Case "1:1"
                            Select rand($25, $01)
                                Case $01
                                    local0 = createitem("Document SCP-106", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $02
                                    local0 = createitem("Document SCP-079", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $03
                                    local0 = createitem("Document SCP-173", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $04
                                    local0 = createitem("Document SCP-895", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $05
                                    local0 = createitem("Document SCP-682", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $06
                                    local0 = createitem("Document SCP-860", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $07
                                    local0 = createitem("SCP-035 Addendum", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $08
                                    local0 = createitem("Document SCP-1162", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $09
                                    local0 = createitem("Document SCP-096", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $0A
                                    local0 = createitem("Document SCP-035", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $0B
                                    local0 = createitem("Document SCP-966", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $0C
                                    local0 = createitem("Document SCP-970", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $0D
                                    local0 = createitem("Document SCP-939", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $0E
                                    local0 = createitem("Document SCP-012", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $0F
                                    local0 = createitem("Document SCP-008", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $10
                                    local0 = createitem("Document SCP-714", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $11
                                    local0 = createitem("Document SCP-1499", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $12
                                    local0 = createitem("Document SCP-1123", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $13
                                    local0 = createitem("Document SCP-049", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $14
                                    local0 = createitem("Document SCP-513", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $15
                                    local0 = createitem("Document SCP-1048", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $16
                                    local0 = createitem("Document SCP-500", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $17
                                    local0 = createitem("SCP-457 Addendum", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $18
                                    local0 = createitem("Document SCP-1079", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $19
                                    local0 = createitem("Document SCP-457", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $1A
                                    local0 = createitem("Document SCP-198", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $1B
                                    local0 = createitem("Document SCP-650", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $1C
                                    local0 = createitem("Document SCP-409", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $1D
                                    local0 = createitem("Document SCP-005", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $1E
                                    local0 = createitem("Document SCP-178", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $1F
                                    local0 = createitem("Document SCP-215", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $20
                                    local0 = createitem("Document SCP-447", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $21
                                    local0 = createitem("Document SCP-109", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $22
                                    local0 = createitem("Document SCP-357", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $23
                                    local0 = createitem("Document SCP-207", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $24
                                    local0 = createitem("Document SCP-402", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                                Case $25
                                    local0 = createitem("Document SCP-1033-RU", "paper", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                            End Select
                        Case "fine","very fine"
                            local0 = createitem("Origami", "misc", arg2, arg3, arg4, $00, $00, $00, 1.0, $00)
                    End Select
                    removeitem(arg0)
                Default
                    positionentity(arg0\Field1, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field1)
            End Select
    End Select
    If (local0 <> Null) Then
        entitytype(local0\Field1, $03, $00)
    EndIf
    Return $00
End Function
