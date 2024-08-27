Function dropitem%(arg0.items, arg1%)
    Local local0%
    If (wearinghazmat > $00) Then
        msg = scplang_getphrase("items.hazmaterr8")
        msgtimer = 350.0
        Return $00
    EndIf
    If (arg1 <> 0) Then
        If (arg0\Field3\Field2 <> $42) Then
            playsound_strict(picksfx(arg0\Field3\Field2))
        EndIf
    EndIf
    arg0\Field16 = $01
    showentity(arg0\Field1)
    positionentity(arg0\Field1, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
    rotateentity(arg0\Field1, entitypitch(camera, $00), (entityyaw(camera, $00) + rnd(-20.0, 20.0)), 0.0, $00)
    moveentity(arg0\Field1, 0.0, -0.1, 0.1)
    rotateentity(arg0\Field1, 0.0, (entityyaw(camera, $00) + rnd(-110.0, 110.0)), 0.0, $00)
    resetentity(arg0\Field1)
    arg0\Field15 = $00
    For local0 = $00 To (maxitemamount - $01) Step $01
        If (inventory(local0) = arg0) Then
            inventory(local0) = Null
        EndIf
    Next
    Select arg0\Field3\Field1
        Case "gasmask","supergasmask","gasmask3"
            wearinggasmask = $00
        Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
            wearinghazmat = $00
        Case "vest","finevest"
            wearingvest = $00
        Case "nvgoggles"
            If (wearingnightvision = $01) Then
                camerafogfar = storedcamerafogfar
                wearingnightvision = $00
            EndIf
        Case "supernv"
            If (wearingnightvision = $02) Then
                camerafogfar = storedcamerafogfar
                wearingnightvision = $00
            EndIf
        Case "finenvgoggles"
            If (wearingnightvision = $03) Then
                camerafogfar = storedcamerafogfar
                wearingnightvision = $00
            EndIf
        Case "scp714"
            i_714\Field0 = $00
        Case "scp1499","super1499"
            i_1499\Field0 = $00
        Case "scp427"
            i_427\Field0 = $00
        Case "scp178"
            i_178\Field0 = $00
        Case "scp215"
            i_215\Field0 = $00
        Case "scp1033ru","super1033ru"
            i_1033ru\Field2 = $00
        Case "scp402"
            i_402\Field0 = $00
        Case "scp357"
            i_357\Field0 = 0.0
        Case "helmet"
            wearinghelmet = $00
    End Select
    Return $00
End Function
