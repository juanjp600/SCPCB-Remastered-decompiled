Function console_spawnnpc%(arg0$, arg1$)
    Local local0.npcs
    Local local1$
    Select arg0
        Case "0081","0081zombie","scp008-1","scp-008-1","scp0081","008-1"
            local0 = createnpc($01, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local0\Field9 = 1.0
            local1 = "SCP-008-1 spawned."
        Case "049","scp049","scp-049"
            local0 = createnpc($03, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local0\Field9 = 1.0
            local1 = "SCP-049 spawned."
        Case "049-2","0492","scp-049-2","scp049-2","049zombie","zombie","scp-0492"
            local0 = createnpc($04, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local0\Field9 = 1.0
            local1 = "SCP-049-2 spawned."
        Case "066","scp066","scp-066"
            local0 = createnpc($05, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            If (curr066 = Null) Then
                curr066 = local0
            EndIf
            local1 = "SCP-066 spawned."
        Case "096","scp096","scp-096"
            local0 = createnpc($06, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local0\Field9 = 5.0
            If (curr096 = Null) Then
                curr096 = local0
            EndIf
            local1 = "SCP-096 spawned."
        Case "106","scp106","scp-106","larry"
            local0 = createnpc($07, entityx(collider, $00), (entityy(collider, $00) - 0.5), entityz(collider, $00))
            local0\Field9 = -1.0
            local1 = "SCP-106 spawned."
        Case "173","scp173","scp-173","statue"
            local0 = createnpc($08, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            curr173 = local0
            If (3.0 = curr173\Field24) Then
                curr173\Field24 = 0.0
            EndIf
            local1 = "SCP-173 spawned."
        Case "372","scp372","scp-372"
            local0 = createnpc($09, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "SCP-372 spawned."
        Case "513-1","5131","scp513-1","scp-513-1"
            local0 = createnpc($0A, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "SCP-513-1 spawned."
        Case "860-2","8602","scp860-2","scp-860-2"
            createconsolemsg("SCP-860-2 cannot be spawned with the console. Sorry!", $FF, $00, $00, $00)
        Case "939","scp939","scp-939"
            createconsolemsg("SCP-939 instances cannot be spawned with the console. Sorry!", $FF, $00, $00, $00)
        Case "966","scp966","scp-966"
            local0 = createnpc($0D, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "SCP-966 instance spawned."
        Case "1048-a","scp1048-a","scp-1048-a","scp1048a","scp-1048a","1048a"
            createconsolemsg("SCP-1048-A cannot be spawned with the console. Sorry!", $FF, $00, $00, $00)
        Case "1499-1","14991","scp-1499-1","scp1499-1"
            local0 = createnpc($0F, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "SCP-1499-1 instance spawned."
        Case "class-d","classd","d"
            local0 = createnpc($12, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "D-Class spawned."
        Case "guard"
            local0 = createnpc($13, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "Guard spawned."
        Case "mtf"
            local0 = createnpc($14, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "MTF unit spawned."
        Case "apache","helicopter"
            local0 = createnpc($10, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "Apache spawned."
        Case "tentacle","scp035tentacle","035tentacle","scp-035-tentacle","scp035-tentacle","scp035-tentacle"
            local0 = createnpc($02, entityx(collider, $00), (entityy(collider, $00) - 0.12), entityz(collider, $00))
            local1 = "SCP-035 tentacle spawned."
        Case "clerk"
            local0 = createnpc($11, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "Clerk spawned."
        Case "650","scp650","scp-650","black statue"
            local0 = createnpc($1A, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            If (curr650 = Null) Then
                curr650 = local0
            EndIf
            local0\Field24 = 0.0
            If (3.0 = curr650\Field24) Then
                curr650\Field24 = 0.0
            EndIf
            local1 = "SCP-650 spawned."
        Case "scp-457","457","scp457"
            createconsolemsg("SCP-457 cannot be spawned with the console. Sorry!", $FF, $00, $00, $00)
        Case "0493","049-3","scp049-3","scp-049-3","scp-0493","scp0493","049zombie2","zombie2"
            local0 = createnpc($17, entityx(collider, $00), (entityy(collider, $00) + 0.23), entityz(collider, $00))
            local0\Field9 = 1.0
            local1 = "SCP-049-3 spawned."
        Case "0082","008-2","scp-008-2","scp008-2","0082zombie"
            local0 = createnpc($16, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local0\Field9 = 1.0
            local1 = "SCP-008-2 spawned."
        Case "178-1","1781","scp-178-1","scp178-1","scp-1781"
            local0 = createnpc($18, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "SCP-178-1 instance spawned."
            createconsolemsg("SCP-178-1 instances will be invisible unless you equip SCP-178.", $FF, $FF, $00, $00)
        Case "mtf2"
            local0 = createnpc($1C, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "MTF unit spawned."
        Case "ci"
            local0 = createnpc($1B, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "CI unit spawned."
        Case "vehicle","introvehicle","intro_vehicle","truck"
            local0 = createnpc($1D, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
            local1 = "Vehicle spawned."
        Default
            createconsolemsg("NPC type not found.", $FF, $00, $00, $00)
            Return $00
    End Select
    If (local0 <> Null) Then
        If (arg1 <> "") Then
            local0\Field9 = (Float arg1)
            local1 = (((local1 + " (State = ") + (Str local0\Field9)) + ")")
        EndIf
    EndIf
    createconsolemsg(local1, $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
    Return $00
End Function
