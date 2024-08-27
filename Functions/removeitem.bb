Function removeitem%(arg0.items)
    Local local0%
    freeentity(arg0\Field2)
    freeentity(arg0\Field1)
    arg0\Field1 = $00
    For local0 = $00 To (maxitemamount - $01) Step $01
        If (inventory(local0) = arg0) Then
            inventory(local0) = Null
            itemamount = (itemamount - $01)
            Exit
        EndIf
    Next
    If (selecteditem = arg0) Then
        Select selecteditem\Field3\Field1
            Case "nvgoggles","supernv"
                wearingnightvision = $00
            Case "gasmask","supergasmask","gasmask2","gasmask3"
                wearinggasmask = $00
            Case "vest","finevest","veryfinevest"
                wearingvest = $00
            Case "hazmatsuit","hazmatsuit2","hazmatsuit3"
                wearinghazmat = $00
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
            Case "helmet"
                wearinghelmet = $00
            Case "scp357"
                i_357\Field0 = 0.0
        End Select
        selecteditem = Null
    EndIf
    If (arg0\Field3\Field11 <> $00) Then
        freeimage(arg0\Field3\Field11)
        arg0\Field3\Field11 = $00
    EndIf
    Delete arg0
    Return $00
End Function
